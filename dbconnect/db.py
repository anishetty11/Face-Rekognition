import mysql.connector




class Patient(object):

	insert_qurey="Insert into patients_d values(%s,%s,%s)"
	retrieve_query="Select * from patients_d"

	def __init__(self, ids, name, phone):
		self.id=ids
		self.name=name
		self.phone=phone

	def add_to_table(self,cursor,conn):
		cursor.execute(self.insert_qurey,(self.id,self.name,self.phone))
		conn.commit()
		cursor.close()

	def get_from_table(self,cursor):
		cursor.execute(self.retrieve_query)
		row=cursor.fetchone()
		patient_list=[]
		while row is not None:
			patient_list.append(row)
			row=cursor.fetchone()
		cursor.close()
		return patient_list



def get_patient_details():
	try:
		conn = mysql.connector.connect(user='anish', password='wireless',
		                              host='firstdb.cw9af5qh8t7w.us-west-2.rds.amazonaws.com',
		                              database='demo')

		print ("Connected to database")
	except e:
		print("Error in connection")
	p=Patient(None,None,None)
	#p.add_to_table(conn.cursor(),conn)
	patients=p.get_from_table(conn.cursor())
	patient_images=[]
	for i in patients:
		patient_images.append(i[1])
	#print (patient_images)

	conn.close()
	return patient_images


