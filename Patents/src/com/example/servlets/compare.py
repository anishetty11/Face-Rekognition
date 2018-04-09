from dbconnect import db
from capture_image import get_image
from gul_bad_code import upload
import boto3
import sys
import os





g=open("program_executed.txt",'w')
try:
	client=boto3.client('rekognition','us-west-2')
	
	#image_binary=get_image.capture_image()

	imageFile="temp.jpg"
	image = open(imageFile,'rb')
	image_binary=(image.read())
	
	SourceImage_list=db.get_patient_details()
	for i in SourceImage_list:
		print ("---->Checking the image with: ",i)
		try:
			response = client.compare_faces(
				SourceImage={
					
					'S3Object': {
						'Bucket': 'patients-recogn',
						'Name': i,
						#'Version': 'string'
					}
				},
				TargetImage={
					#'Bytes': b'bytes',
					'Bytes': image_binary
					#'S3Object': {
					#   'Bucket': 'patients-recogn-refer',
					#   'Name': 'input3.jpg',
						#'Version': 'string'
					
				},
				SimilarityThreshold=70
			)
			if len(response['UnmatchedFaces'])==0:
				print ("\n\n~~~~~~~~~~~~Face has a match:" + i+"~~~~~~~~~~~~~~\n") 
				f=open("~~face_matched.txt",'w')
				row=db.get_details(i)
				for j in row:
					f.write(str(j)+'\n')
				f.close()
				sys.exit()
		except Exception as e:
			print ("Error in loading image from s3 (",i,"    :",e)
			continue
		


except Exception as e:
	print ("\n:(\nFace not detected:    ",e)

print( " No match found, add new user? y/n")
if os.path.isfile("~~tmp.txt"):
	os.remove("~~tmp.txt")

if(input()=='y'):
	upload.uploadImage()






