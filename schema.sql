BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, node, user_progress;

create table users (
	id SERIAL PRIMARY KEY,
	username varchar(20) UNIQUE NOT NULL
	--no need for password, its a literal puzzle.
);

create table node (
	id SERIAL PRIMARY KEY,
	code varchar(5) UNIQUE,
	type varchar(15),
	content text,
	status varchar(20)	
);

create table user_progress(
	user_id int,
	node_id int,
	visited_at timestamp,
	status varchar(20),
	PRIMARY KEY(user_id, node_id),
	CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT fk_user_progress FOREIGN KEY (node_id) REFERENCES node(id) ON DELETE CASCADE ON UPDATE CASCADE
);


COMMIT;