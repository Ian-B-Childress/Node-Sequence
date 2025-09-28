--this destroys the db and associated users for testing

SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'dynamic_node_sequence';

DROP DATABASE dynamic_node_sequence;

DROP USER node_sequence_owner;
DROP USER node_sequence_user;