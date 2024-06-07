	This is an application that aims to automate the process of filling and sending through mail of an excel file containing all the work shifts done.

	The process should consist in some way in these steps:
		1. At the absolute beginning, the employee must fill a form that has these fields:
			- name and surname
			- shift start time
			- shift end time
			- # of hours for lunch-break (usually 1, but better to ask)
			- access to food stamps? Y or n
			- date of hire
			- # of company employees (important for calculating # of days off the employee has access to)
			- default activity (what does the employee usually do)
			- client the employee works for
			- employee's e-mail address
			- e-mail addresses to send the excel file to other than the boss
		   All of these must be stored in a table inside a DB (most probably a MySQL DB).

		2. Every month, inside the application the employee must state:
			- how many hours of leave she/he consumed
			- how many days off he/she consumed
			- other absences for various reasons
			- how many hours/days of off work availability
		   All of the above should default at zero.

		3. When clicking a "preview" button, a table should be generated with the following columns:
			- Day
			- Absence for holiday, sickness or hours of leave
			- hours leave
			- start (of shift)
			- end (of shift)
			- lunch-break
			- activity
			- client
			- hours presence
			- delta
		   The table cells, except for the headers row, weekends and national holidays (including the 14th of august as a company holiday) rows and the "Day" column, should be enabled to allow modifications. Weekends and holidays rows should be of a darker color, with the holiday rows containing the name of the holiday.

		   4. After reviewing the table, the employee should save it (with the addition of a top row containing information about the employee) as an excel file by clicking a "Generate file" button.
		   
		   Optional step. the employee has the option to click a "Generate and send file" button to save the table and automatically send the file to the boss and eventually other people.