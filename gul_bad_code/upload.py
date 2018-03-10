import boto3
import pygame
import pygame.camera

import mysql.connector
conn = mysql.connector.connect(host='firstdb.cw9af5qh8t7w.us-west-2.rds.amazonaws.com',database='demo',user='anish',password='wireless')

Name = input("Enter patient name: ")+'.jpg'
Phone = input("Enter mobile number: ")


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

########################################################
DEVICE = '/dev/video0'
SIZE = (640,480)

pygame.init()
pygame.camera.init()
cam = pygame.camera.Camera(DEVICE,SIZE)
cam.start()
img = cam.get_image()
#ID = str(ID)+'.jpg'
pygame.image.save(img,Name)

cam.stop()
##########################################################
client = boto3.client('s3','us-west-2')

bucket_name = 'patients-recogn'

client.upload_file(Name,bucket_name,Name)