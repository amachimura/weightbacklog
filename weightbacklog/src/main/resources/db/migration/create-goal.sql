create table goal IF NOT EXISTS (
	id uuid primary key,
	user_id uuid not null,
	slogan text,
	start_weight numeric(5,2),
	start_date date,
	goal_weight numeric(5,2),
	goal_date date,
);