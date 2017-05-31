# messageProcessing
Sales Messaging Processing excercise

Message Processing Application
__________________________________

Objective : Implement a small message processing application that satisfies the below requirements for processing sales notification messages. You should assume that an external company will be sending you the input messages, but for the purposes of this exercise you are free to define the interfaces.

Requirements:

	•	All sales must be recorded
	•	All messages must be processed
	•	After every 10th message received your application should log a report detailing the number of sales of each product and their total value.
	•	After 50 messages your application should log that it is pausing, stop accepting new messages and log a report of the adjustments that have been made to each sale type while the application was running.


Sales and Messages

	A sale has a product type field and a value – you should choose sensible types for these.
	Any number of different product types can be expected. There is no fixed set.
	A message notifying you of a sale could be one of the following types
		•	Message Type 1 – contains the details of 1 sale E.g apple at 10p
		•	Message Type 2 – contains the details of a sale and the number of occurrences of that sale. E.g 20 sales of apples at 10p each.
		•	Message Type 3 – contains the details of a sale and an adjustment operation to be applied to all stored sales of this product type. Operations can be add, subtract, or multiply e.g Add 20p apples would instruct your application to add 20p to each sale of apples you have recorded.

Assumptions

	1)	A message could be in one of the following pattern
			•	Message Type 1 pattern – apple at 10p
			•	Message Type 2 pattern - 20 sales of apples at 10p each.
			•	Message Type 3 pattern – Add 20p apples would instruct your application to add 20p to each sale of apples you have recorded.
	
		Any message which does not follow the above pattern are considered invalid.Null is an invalid message.
	
	2)	Multiple adjustments are allowed for each sale type.

	3)	Messages will have values in p (pence). All price values are displayed in pence except for Total value in Reports.

	4)	The input message is read from a text file.Output is printed to the console.

	5)	The maximum number of messages processed is set to 250 arbitarily.

	6)	After 50 messages the system pauses for 5 seconds and resumes to read.

	7)	Reports are generated at an interval of 10 messages. However if there are 25 messages, the system logs report till 20 messages only.
		No reports will be generated for less than 10 messages. 

	8)	The test input files are kept in the test folder of MessageProcessingApp.
	
	9)	The application is single threaded. 
	
	10) System throws error if there are no previous records for an adjustment sale.
	 
