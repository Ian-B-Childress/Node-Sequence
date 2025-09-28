--creates the database users and grants perms


CREATE USER node_sequence_owner
WITH PASSWORD 'sequence';

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO node_sequence_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO node_sequence_owner;

CREATE USER node_sequence_user
WITH PASSWORD 'sequence';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO node_sequence_user;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO node_sequence_user;

