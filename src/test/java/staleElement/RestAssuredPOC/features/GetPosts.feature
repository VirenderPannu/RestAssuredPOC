Feature: GETPosts
              Verify different GET operations using REST-Assured and fake json-server

        Scenario: Verify one author of the post
            Given I perform GET operation for "/posts"
             Then I should see the author name as "virender"

        Scenario: Verify collection of authors in the post
            Given I perform GET operation for "/posts"
             Then I should see the author names

        # Scenario: Verify Parameter of Get
        #     Given I perform GET operation for "/posts"
        #      Then I should see verify GET Parameter

        # Scenario: Verify GET operation with bearer authentication token
        #     Given I perform authentication operation for "/auth/login" with body
        #           | email              | password |
        #           | virender@email.com | test123  |
        #     Given I perform GET operation for "/posts/1"
        #      Then I should see the author name as "Virender Singh"

        # Scenario: Verify GET operation with json validation
        #     Given I perform authentication operation for "/auth/login" with body
        #           | email              | password |
        #           | virender@email.com | test123  |
        #     Given I perform GET operation for "/posts/1"
        #      Then I should see the author name as "Virender Singh" with json validation
