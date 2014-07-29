#!/bin/sh
set -eu
: ${DEPLOY_USERNAME:?}
: ${DEPLOY_PASSWORD:?}
set -x
 
VERSION=`cat artifacts/version`

curl \
  --silent --fail --show-error \
  --basic --user "$DEPLOY_USERNAME:$DEPLOY_PASSWORD" \
  --form r=releases \
  --form hasPom=false \
  --form g=com.example.rest.person \
  --form a=PersonService \
  --form v="$VERSION" \
  --form e=war \
  --form p=war \
  --form file="@artifacts/PersonService-$VERSION.war" \
  http://localhost:8081/nexus/service/local/artifact/maven/content
