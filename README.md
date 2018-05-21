# spring-oauth2-groovy
Git Location: https://github.com/bmuthekar/spring-oauth2-groovy
Implemented Spring security, oAuth2, JWT, Spring Rest exception handling, JSR303, Signup, thymeleaf

Spring boot JWT-oAuth2 security-groovy
{"access_token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiam9obi5kb2UiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTI2NTExNTIyLCJhdXRob3JpdGllcyI6WyJTVEFOREFSRF9VU0VSIl0sImp0aSI6IjI1MGRiYzFlLTJlZDctNDg2Yy05ZjdmLTQ2ZWRhYTg4YjRjNCIsImNsaWVudF9pZCI6InRlc3Rqd3RjbGllbnRpZCJ9.-zT2hOIf-o8-PCEc1Q4rJ9EDJO5RszdQ9hQW0gxru_o","token_type":"bearer","expires_in":43199,"scope":"read write","jti":"250dbc1e-2ed7-486c-9f7f-46edaa88b4c4"}


curl http://localhost:8010/springjwt/cities -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiam9obi5kb2UiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTI2NTExNTIyLCJhdXRob3JpdGllcyI6WyJTVEFOREFSRF9VU0VSIl0sImp0aSI6IjI1MGRiYzFlLTJlZDctNDg2Yy05ZjdmLTQ2ZWRhYTg4YjRjNCIsImNsaWVudF9pZCI6InRlc3Rqd3RjbGllbnRpZCJ9.-zT2hOIf-o8-PCEc1Q4rJ9EDJO5RszdQ9hQW0gxru_o"


curl testjwtclientid:XY7kmzoNzl100@localhost:8010/oauth/token -d grant_type=password -d username=bhishma -d password=testpass
