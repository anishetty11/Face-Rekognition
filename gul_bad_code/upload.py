import boto3
import pygame
import pygame.camera
import mysql.connector
import time
import os

Name ='**'
Phone = '**''

def push_to_db():
	try:
		conn = mysql.connector.connect(host='firstdb.cw9af5qh8t7w.us-west-2.rds.amazonaws.com',database='demo',user='anish',password='wireless')

		cursor = conn.cursor()
		query = 'select ID from patients_d'
		cursor.execute(query)
		ID = len(cursor.fetchall()) + 1

		query = 'insert into patients_d values(%s,%s,%s)'
		args = (ID,Name,Phone)
		cursor.execute(query,args)

		conn.commit()
		cursor.close()
		conn.close()

	except Exception as e:
		print(e)

def getImage():
	DEVICE = '/dev/video0'
	SIZE = (640,480)

	pygame.init()
	pygame.camera.init()
	cam = pygame.camera.Camera(DEVICE,SIZE)
	print("Capturing Image....")
	time.sleep(2)
	cam.start()
	img = cam.get_image()
	pygame.image.save(img,'temp.jpg')
	cam.stop()

def uploadImage():
	global Name
	global Phone


	Name = input("Enter patient name: ")+'.jpg'
	Phone = input("Enter mobile number: ")
	os.rename('temp.jpg',Name)

	client = boto3.client('s3','us-west-2')

	bucket_name = 'patients-recogn'

	client.upload_file(Name,bucket_name,Name)

	push_to_db()



getImage()
uploadImage()
