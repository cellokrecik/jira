The application connects to Ocado Jira Rest Api - https://ocadotech.atlassian.net/rest/api/3 and gets all issues in the given epic key.
Each issue has a field "fields" with a map of different objects - the tshirt size is most likely a custom field. 
To check how that field is called in Ocado it might be call under https://ocadotech.atlassian.net/rest/api/3/field endpoint.
The list of names - T-shirt Size in Ocado: 
      "customfield_11000" 
      "customfield_11040"
      "customfield_11974"
      "customfield_11154"
      "customfield_10492"
      "customfield_10484"
To check which fields can be updated - the endpoint GET /rest/api/3/issue/{issueIdOrKey}/editmeta can be used.   

The application stores weights configuration in h2 database (in-memory) and provides an API to display/modify those values by id.

The application has some unit and integration tests.

To run the application Basic auth for REST APIs is needed : an Atlassian account email address and API token.
