create table sprint IF NOT EXISTS (
	id uuid primary key,
	user_id uuid not null,
	goal_id uuid not null,
	start_weight numeric(5,2),
	start_date date,
	goal_weight numeric(5,2),
	goal_date date,
);