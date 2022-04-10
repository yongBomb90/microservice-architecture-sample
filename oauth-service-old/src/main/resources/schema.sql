USE MTBX;
/**
INSERT INTO CLIENT
(
  ACCESS_TOKEN_VALIDITY_SECS
, AUTHORITIES
, AUTO_APPROVE
, CLIENT_ID
, CLIENT_SECRET
, GRANT_TYPES
, REDIRECT_URI
, REFRESH_TOKEN_VALIDITY_SECS
, RESOURCE_IDS
, SCOPE
) VALUE (
100000
,'user,admin'
,false
,'su'
,'{bcrypt}$2a$10$sKzvFhTOO1uzQpTebOQBcewEPTwtzoqWvf/AjW20I.f7imnYa2s5.'
,'authorization_code,implicit,password,client_credentials,refresh_token'
,'/oauth-callback'
,50000
,'client'
,'read,write,trust'
);
**/
