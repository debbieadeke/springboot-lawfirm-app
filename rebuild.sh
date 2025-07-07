#!/bin/bash

echo "🔄 Building project with Maven..."
cd springboot-lawfirm || exit
mvn clean package -DskipTests
cd ..

echo "🛑 Stopping and removing containers..."
docker-compose down

echo "🐳 Rebuilding Docker images (no cache)..."
docker-compose build --no-cache

echo "🚀 Starting containers..."
docker-compose up -d

echo "✅ Project rebuilt and containers started successfully!"
