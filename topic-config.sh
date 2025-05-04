#!/bin/bash

# Function to check if Kafka is ready
check_kafka() {
    local retries=30
    local wait_time=10
    
    echo "Waiting for Kafka brokers to be ready..."
    
    for i in $(seq 1 $retries); do
        if kafka-topics --list --bootstrap-server kafka-broker-2:9093,kafka-broker-3:9094 &>/dev/null; then
            echo "Successfully connected to Kafka"
            return 0
        fi
        
        echo "Attempt $i/$retries: Kafka is not ready yet. Waiting ${wait_time} seconds..."
        sleep $wait_time
    done
    
    echo "Failed to connect to Kafka after $retries attempts"
    return 1
}

# Wait for Kafka to be ready
if ! check_kafka; then
    echo "Could not connect to Kafka. Exiting."
    exit 1
fi

# Create topics
echo "Creating Kafka topics..."

kafka-topics --create --topic successful-payments --bootstrap-server kafka-broker-2:9093,kafka-broker-3:9094 --partitions 3 --replication-factor 2 --config min.insync.replicas=1 --if-not-exists
echo "Topic 'successful-payments' created successfully."

kafka-topics --create --topic book-tickets-request --bootstrap-server kafka-broker-2:9093,kafka-broker-3:9094 --partitions 3 --replication-factor 2 --config min.insync.replicas=1 --if-not-exists
echo "Topic 'book-tickets-request' created successfully."

kafka-topics --create --topic booked-tickets --bootstrap-server kafka-broker-2:9093,kafka-broker-3:9094 --partitions 3 --replication-factor 2 --config min.insync.replicas=1 --if-not-exists
echo "Topic 'booked-tickets' created successfully."

# List all topics to verify creation
echo "Listing all topics:"
kafka-topics --list --bootstrap-server kafka-broker-2:9093,kafka-broker-3:9094

# Keep the container running
tail -f /dev/null
