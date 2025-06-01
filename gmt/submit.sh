#!/bin/bash
set -euo pipefail

BASEDIR=$(dirname $0)
source $BASEDIR/.env

# Check if jq is installed
if ! command -v jq &> /dev/null; then
    echo "jq command not found. Please install jq to parse JSON."
    exit 1
fi

# Select GMT server instance
echo "Choose the GMT server for submission:"
echo "- internal: $API_URL_INTERNAL"
echo "- public: $API_URL_PUBLIC"
read server_choice
case $server_choice in
  internal)
    API_URL=$API_URL_INTERNAL
    API_TOKEN="" # reset API token
    ;;
  public)
    API_URL=$API_URL_PUBLIC
    ;;
  *)
    echo "Invalid input!"
    exit 1
    ;;
esac

# Get available machines
response=$(curl -s $API_URL/v1/machines \
 -H "X-Authentication: ${API_TOKEN}")

success=$(echo "$response" | jq -r '.success')

if [ "$success" = "true" ]; then
    machines=$(echo "$response" | jq -r '.data[] | select(.[2] == true) | "\(.[0]) \(.[1])"')
else
    echo "Failed to retrieve machine data." > `tty`
    exit 1
fi

if [ ${#machines} -eq 0 ]; then
    echo "No available machines."
    exit 1
fi

echo ""
echo "Available machines:"
for machine in "${machines[@]}"; do
    echo "$machine"
done

echo ""
read -p "Enter the ID of the machine you want to use: " selected_id

# Validate the selected ID
selected_machine=$(printf '%s\n' "${machines[@]}" | grep "^$selected_id" | head -n 1)

if [[ -z "$selected_machine" ]]; then
    echo "Invalid machine ID!"
    exit 1
fi

echo ""
echo "Data to submit:"
echo "---------------"
echo "GMT Server: $API_URL"
echo "GMT Machine: $selected_machine"
echo ""
echo "Name: $NAME"
echo "Repo-URL: $REPO_URL"
echo "Filename: $FILENAME"
echo "Branch: $BRANCH"
echo "Schedule mode: $SCHEDULE_MODE"

echo ""
echo "Press any key to continue..."
read -s -n 1
echo ""

# Submit software
response=$(curl -s -X POST $API_URL/v1/software/add \
 -H "X-Authentication: ${API_TOKEN}" \
 -H 'Content-Type: application/json' \
 --data-raw '{"name":"'"$NAME"'", "email":"'"$EMAIL"'", "repo_url":"'"$REPO_URL"'", "filename":"'"$FILENAME"'", "branch":"'"$BRANCH"'", "machine_id":'$selected_id', "schedule_mode":"'"$SCHEDULE_MODE"'"}'
)
success=$(echo "$response" | jq -r '.success')

if [ "$success" = "true" ]; then
    echo -e "Submit successful!\n"
else
    echo -e "Submit failed!\n"
    error=$(echo "$response" | jq -r '.err')
    echo "Error: $error"
fi
