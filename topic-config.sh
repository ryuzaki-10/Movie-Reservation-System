#!/bin/bash

# Wait for Kafka to be ready
sleep 10

# Check if the topic already exists

  kafka-topics --create --topic successful-payments --bootstrap-server kafka-broker-1:9092,kafka-broker-2:9093,kafka-broker-3:9094 --partitions 3 --replication-factor 3 --config min.insync.replicas=2 --if-not-exists
  echo "Topic 'book-tickets-request' created successfully."


  kafka-topics --create --topic book-tickets-request --bootstrap-server kafka-broker-1:9092,kafka-broker-2:9093,kafka-broker-3:9094 --partitions 3 --replication-factor 3 --config min.insync.replicas=2 --if-not-exists
  echo "Topic 'book-tickets-request' created successfully."


    kafka-topics --create --topic booked-tickets --bootstrap-server kafka-broker-1:9092,kafka-broker-2:9093,kafka-broker-3:9094 --partitions 3 --replication-factor 3 --config min.insync.replicas=2 --if-not-exists
    echo "Topic 'booked-tickets' created successfully."
#!/bin/bash

# Keep the container running
tail -f /dev/null
