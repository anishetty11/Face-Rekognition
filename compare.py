import boto3
import pprint
if __name__ == "__main__":
    #fileName='input.jpg'
    #bucket='patients-recogn'
    
    client=boto3.client('rekognition','us-west-2')
    #response = client.detect_labels(Image={'S3Object':{'Bucket':bucket,'Name':fileName}})
    #print('Detected labels for ' + fileName)    
    #for label in response['Labels']:
    #    print (label['Name'] + ' : ' + str(label['Confidence']))
    imageFile="fake.jpg"
    image = open(imageFile,'rb')
    SourceImage='input.jpg'
    response = client.compare_faces(
        SourceImage={
            
            'S3Object': {
               'Bucket': 'patients-recogn',
               'Name': SourceImage,
               #'Version': 'string'
            }
        },
        TargetImage={
            #'Bytes': b'bytes',
            'Bytes': image.read()
            #'S3Object': {
            #   'Bucket': 'patients-recogn-refer',
            #   'Name': 'input3.jpg',
                #'Version': 'string'
            
        },
        SimilarityThreshold=80
    )
    print (SourceImage,": ",len(response['UnmatchedFaces'])==0)