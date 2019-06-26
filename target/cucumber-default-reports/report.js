$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Login.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I see OrangeHrm logo",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.i_see_OrangeHrm_logo()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Valid Login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    },
    {
      "name": "@login"
    },
    {
      "name": "@temp"
    }
  ]
});
formatter.step({
  "name": "I enter valid usernameand password",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.i_enter_valid_usernameand_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I clicked Login button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.i_clicked_Login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I successfully logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.i_successfully_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});