package functionaltests.auth

import functionaltests.pages.HomePage
import functionaltests.pages.LoginPage
import functionaltests.pages.StatusPage
import functionaltests.pages.UserPage
import geb.spock.GebSpec
import grails.test.mixin.integration.Integration

@Integration
class LoginFunctionalSpec extends GebSpec{

    void 'test expected redirects'() {
        when:
        go '/'

        then:
        at HomePage

        when:
        go '/status'

        then:
        at LoginPage

        when:
        go '/users'

        then:
        at LoginPage
    }

    void 'test authentication'() {
        when:
        go '/logout'

        then:
        at HomePage

        when:
        go '/status'

        then:
        at LoginPage

        when:
        username = 'jeff'
        password = 'password'
        logginButton.click()

        then:
        at StatusPage

        when:
        go '/users'

        then:
        at UserPage

        when:
        go '/'

        then:
        at HomePage

        when:
        go '/status'

        then:
        at StatusPage

        when:
        go '/logout'

        then:
        at HomePage

        when:
        go '/status'

        then:
        at LoginPage
    }
}
