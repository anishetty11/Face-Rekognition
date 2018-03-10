import pygame
import pygame.camera
import time

def capture_image():
	print ('Capturing image in 3...2...1')
	time.sleep(3)
	pygame.camera.init()
	cam = pygame.camera.Camera("/dev/video0",(640,480))
	cam.start()
	img = cam.get_image()
	pygame.image.save(img,"temp.jpg")

	imageFile="temp.jpg"
	image = open(imageFile,'rb')
	image_binary=(image.read())
	cam.stop()
	print ("\nImage has been captured")
	return image_binary
