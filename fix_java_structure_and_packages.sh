#!/bin/bash
# Create directory structure
mkdir -p LOATME-backend/src/main/java/com/loatme/loatmebackend/model
mkdir -p LOATME-backend/src/main/java/com/loatme/loatmebackend/service
mkdir -p LOATME-backend/src/main/java/com/loatme/loatmebackend/controller

# Move files to correct directories
mv LOATME-backend/src/main/java/com/loatme/loatmebackend/User.java LOATME-backend/src/main/java/com/loatme/loatmebackend/model/User.java 2>/dev/null || true
mv LOATME-backend/src/main/java/com/loatme/loatmebackend/UserService.java LOATME-backend/src/main/java/com/loatme/loatmebackend/service/UserService.java 2>/dev/null || true
mv LOATME-backend/src/main/java/com/loatme/loatmebackend/UserController.java LOATME-backend/src/main/java/com/loatme/loatmebackend/controller/UserController.java 2>/dev/null || true

# Fix package declarations
sed -i '1s|^.*$|package com.loatme.loatmebackend.model;|' LOATME-backend/src/main/java/com/loatme/loatmebackend/model/User.java
sed -i '1s|^.*$|package com.loatme.loatmebackend.service;|' LOATME-backend/src/main/java/com/loatme/loatmebackend/service/UserService.java
sed -i '1s|^.*$|package com.loatme.loatmebackend.controller;|' LOATME-backend/src/main/java/com/loatme/loatmebackend/controller/UserController.java
