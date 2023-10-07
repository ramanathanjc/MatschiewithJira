
Feature: Jira Issue Traker
    
    Scenario: Jira issue managemnet
    When Create New Ticket with string body '{"fields": {"project":{"key": "API"},"summary": "REST ye merry gentlemen.","description": "Creating of an issue using project keys and issue type names using the REST API","issuetype": {"name": "Task" }}}'
    Then Validate the status code as 201
    
    Scenario: update the issue
    When update the issue with file '<FileName>'
    Then Validate the status code as 204
    Examples:
    |FileName|
    |updateFile.json|
    
    Scenario Outline: Get the Ticket Details to verify the update details 
    When verify the update details
    Then Validate the status code as 200
    
    Scenario Outline: delete the ticket
    When delete the ticket
    Then Validate the status code as 204
    