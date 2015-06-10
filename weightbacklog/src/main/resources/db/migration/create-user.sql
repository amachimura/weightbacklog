create table goal IF NOT EXISTS (
	id uuid primary key,
	user_id uuid not null,
);