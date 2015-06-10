create table goal IF NOT EXISTS (
	id uuid primary key,
	user_id uuid not null,
	sprint_id uuid,
	today_date date,
	weight numeric(5,2),
	mokuhyou numeric(5,2),
);