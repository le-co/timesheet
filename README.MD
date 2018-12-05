## Open Timesheet

#### What is Open Timesheet ? 

Open timesheet is a free system for work time markings,
the same is maintained on the MIT license.

#### What you need to run Open timesheet ?

> java >= 8

> Postgres database

#### Postgres with docker

```bash
$ docker run --name=timesheet -d -p 5432:5432  -e POSTGRES_PASSWORD=sa -e POSTGRES_USER=sa -e POSTGRES_DB=timesheet postgres
```

#### Check connection active on database

```sql
SELECT * FROM pg_stat_activity;
```

#### If you want custom Timesheet

You can find HTML, CSS and JavaScripts on template folder.

```text
src
--- main
-------- resources
------------------ templates
---------------------------- resouces (ex.: user)
------------------ static
------------------------- css
------------------------- js
```

#### Environments variables

#### Build project

```bash
$ ./mvnw clean install
```

The jar are created in `target` folder.

#### How do you start app

#### Commons Api

#### Health Check 

#### Log file path