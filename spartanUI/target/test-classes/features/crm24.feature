@smoke
Feature: Task module

  @first
  Scenario: user should be able to create a task
    Given go to crm login page
    When should be clickable task module on homePage

  @second
    Scenario Outline: user should be created new task
    When should be written in thing to do
    When click high priority checkBox
    When click addMore and add "<email>"
      Examples: |email|
                |ashtre.32@hotmail.com|
                |jfkdew.21@gmail.com  |

    Scenario:
      Given click send Button
      Then verify new task if it is displayed on home page

