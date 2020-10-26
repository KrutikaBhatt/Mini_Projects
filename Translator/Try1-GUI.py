from tkinter import  *
import tkinter as tk
from tkinter.ttk import Combobox
from tkinter import messagebox
from textblob import TextBlob
import cv2
import numpy as np
import pytesseract
from pytesseract import Output
from tkinter import messagebox
from PIL import ImageTk,Image
import tkinter.font as font
import os
from tkinter import filedialog,Text

filename=""
lang_dict = {'afrikaans': 'af', 'albanian': 'sq', 'amharic': 'am', 'arabic': 'ar', 'armenian': 'hy', 'azerbaijani': 'az', 'basque': 'eu', 'belarusian': 'be', 'bengali': 'bn', 'bosnian': 'bs', 'bulgarian': 'bg', 'catalan': 'ca', 'cebuano': 'ceb', 'chichewa': 'ny', 'chinese (simplified)': 'zh-cn', 'chinese (traditional)': 'zh-tw', 'corsican': 'co', 'croatian': 'hr', 'czech': 'cs', 'danish': 'da', 'dutch': 'nl', 'english': 'en', 'esperanto': 'eo', 'estonian': 'et', 'filipino': 'tl', 'finnish': 'fi', 'french': 'fr', 'frisian': 'fy', 'galician': 'gl', 'georgian': 'ka', 'german': 'de', 'greek': 'el', 'gujarati': 'gu', 'haitian creole': 'ht', 'hausa': 'ha', 'hawaiian': 'haw', 'hebrew': 'he', 'hindi': 'hi', 'hmong': 'hmn', 'hungarian': 'hu', 'icelandic': 'is', 'igbo': 'ig', 'indonesian': 'id', 'irish': 'ga', 'italian': 'it', 'japanese': 'ja', 'javanese': 'jw', 'kannada': 'kn', 'kazakh': 'kk', 'khmer': 'km', 'korean': 'ko', 'kurdish (kurmanji)': 'ku', 'kyrgyz': 'ky', 'lao': 'lo', 'latin': 'la', 'latvian': 'lv', 'lithuanian': 'lt', 'luxembourgish': 'lb', 'macedonian': 'mk', 'malagasy': 'mg', 'malay': 'ms', 'malayalam': 'ml', 'maltese': 'mt', 'maori': 'mi', 'marathi': 'mr', 'mongolian': 'mn', 'myanmar (burmese)': 'my', 'nepali': 'ne', 'norwegian': 'no', 'odia': 'or', 'pashto': 'ps', 'persian': 'fa', 'polish': 'pl', 'portuguese': 'pt', 'punjabi': 'pa', 'romanian': 'ro', 'russian': 'ru', 'samoan': 'sm', 'scots gaelic': 'gd', 'serbian': 'sr', 'sesotho': 'st', 'shona': 'sn', 'sindhi': 'sd', 'sinhala': 'si', 'slovak': 'sk', 'slovenian': 'sl', 'somali': 'so', 'spanish': 'es', 'sundanese': 'su', 'swahili': 'sw', 'swedish': 'sv', 'tajik': 'tg', 'tamil': 'ta', 'telugu': 'te', 'thai': 'th', 'turkish': 'tr', 'ukrainian': 'uk', 'urdu': 'ur', 'uyghur': 'ug', 'uzbek': 'uz', 'vietnamese': 'vi', 'welsh': 'cy', 'xhosa': 'xh', 'yiddish': 'yi', 'yoruba': 'yo', 'zulu': 'zu'}
global varname,languages,varname1
def select_pic():

    print('Selected')
    global filename,img
    filename = filedialog.askopenfilename(initialdir = '/home',title = 'Select an Image',filetypes = (('PNG','*.png'),('All files','*.*')))

    if os.path.exists(filename):
        img = cv2.imread(filename)
        if not img is None and len(img) > 0:
            cv2.imshow('Frame',img)
            cv2.waitKey(20)
            display=img
        else:
            response=tk.messagebox.showinfo("Alert","Please select image")

def ocr_text():
    global text_frame
    global filename
    if os.path.exists(filename):
        img=cv2.imread(filename)
        grey=cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
        blur=cv2.GaussianBlur(grey,(5,5),0)
        x,frame=cv2.threshold(blur,10,255,cv2.THRESH_BINARY+cv2.THRESH_OTSU)
        ocr_text=pytesseract.image_to_string(frame,lang="eng")
        print(ocr_text)
        data=pytesseract.image_to_data(frame,output_type=Output.DICT)
        print(len(data['text']))
        for i in range(len(data['text'])):
            if int(data['conf'][i])>60:
                x,y,w,h=data['left'][i],data['top'][i],data['width'][i],data['height'][i]
                cv2.rectangle(img,(x,y),(x+w,y+h),(0,0,0),1)
                cv2.putText(img,data['text'][i],(x,y),cv2.FONT_HERSHEY_COMPLEX_SMALL,1,(0,0,0),1)
                cv2.imshow('Frame',img)
                cv2.waitKey(500)
        textbox = tk.Frame(text_frame,bg = 'white')
        textbox.place(relx = 0.01,rely = 0.01,relwidth =0.95,relheight =0.95)
        text=Text(textbox,bg='#FDFFD6')
        text.insert('1.0',ocr_text)
        text.pack()
    else:
        response=tk.messagebox.showinfo("Message","Please select image")

def Image_Translate() :
    global filename
    global text_frame
    root1=tk.Tk()
    root1.title("Translate an Image")
    canvas=tk.Canvas(root1,height=600,width=450,bg="white")
    canvas.pack()
    Select=Button(canvas,text="Select Image",padx=5,pady=5,bg="plum3",cursor="hand2",relief=RIDGE,width=12,height=2,borderwidth=1,font=('verdana',11,'bold') ,command=select_pic )
    Select.place(x=150,y=20)
    Recog=Button(canvas,text="Recognize Text",padx=5,pady=5,bg="plum3",cursor="hand2",relief=RIDGE,width=12,height=2,borderwidth=1,font=('verdana',11,'bold'),command=ocr_text )
    Recog.place(x=150,y=95)
    text_frame=tk.Frame(canvas,bg='navajo white')
    text_frame.place(bordermode=OUTSIDE,height=120,width=350,x=50,y=160)

    l2=Label(canvas,text="Select Language:",font=('verdana',11,'bold'),bg="white")
    l2.place(x=50,y=290)

    languages = StringVar()
    font_box = Combobox(canvas,width = 30, textvariable =languages,state ='readonly')
    font_box['values']= [e for e in lang_dict.keys()]
    font_box.current(37)
    font_box.place(x=50,y=315)

    l3=Label(canvas,text="Translated Text",font=('verdana',11,'bold'),bg="white")
    l3.place(x=50,y=340)
    Trans_text=Text(canvas,bg='navajo white')
    Trans_text.insert('1.0','Translated Text shown over here')
    Trans_text.place(x=50,y=360,height=120,width=350)


    #image1=PhotoImage(file='click.png')
    #image2=PhotoImage(file='exit.png')
    #image1 = image1.subsample(2,2)
    #image2 = image2.subsample(2,2)
    bttn1 = Button(root1,text='Translate',bd=10,bg='plum3', width=10,font= ('verdana',11,'italic bold'))
    #bttn1.image=image1
    bttn1.place(x=50,y=500)
    
    bttn2 = Button(root1,text='Exit',bd=10,bg='plum3', width=5,font= ('verdana',11,'italic bold'))
    #bttn2.image=image2
    bttn2.place(x=320,y=500)


    root1.mainloop()

def translate_text_show(event=None):
    global varname,languages,varname1
    print(varname.get())
    print(languages.get())
    try:
        print("Try called")
        word=TextBlob(varname.get())
        lang = word.detect_language()
        lang_to_dict = languages.get()
        lang_to = lang_dict[lang_to_dict]
        word = word.translate(from_lang=lang, to=lang_to)
        label3.configure(text=word)
        varname1.set(word)
        print("Word is",word)
    except:
        varname1.set('Try another Keyword')


def Text_Translate():
    global varname,languages,varname1
    root2=tk.Tk()
    root2.geometry('500x400')
    root2.title('Language Translator')
    root2.configure(bg= 'white')

    label=Label(root2,text='Text Translator',bd=1,fg='firebrick4',font=('verdana',21,'italic bold'),bg='white')
    label.place(x=120,y=20)

    #img = ImageTk.PhotoImage(Image.open('/home/krutika/Python_stuff/click.png'))
    #tile = Label(root2, image = img)
    #tile.image = img
    #tile.place(x=50,y=50,height=200,width=250)
    label1 = Label(root2,text='Enter Words :',font= ('verdana',13,'italic bold'),bg='white')
    label1.place(x=50,y=80)
    
    varname = StringVar()
    data1 = Entry(root2,width=30,textvariable=varname,font=('verdana',12,''))
    data1.place(x=50,y=110)
    
    label2 = Label(root2,text='Languages :',font= ('verdana',13,'italic bold'),bg='white')
    label2.place(x=50,y=155)
    languages = StringVar()
    font_box = Combobox(root2,width = 30, textvariable =languages,state ='readonly')
    font_box['values']= [e for e in lang_dict.keys()]
    font_box.current(37)
    font_box.place(x=50,y=180)

    label3 = Label(root2,text='Translated Text:',font= ('verdana',13,'italic bold'),bg='white')
    label3.place(x=50,y=205)
    varname1 = StringVar()
    data2 = Entry(root2,width=30,textvariable=varname1,font=('verdana',12,''))
    data2.place(x=50,y=230)
    
    Translate=Button(root2,text="Translate",padx=5,bg="plum3",width=10,cursor="hand2",relief=RIDGE,borderwidth=1,font=('verdana',13,'bold'),command=translate_text_show)
    Translate.place(x=50,y=290)
    
    Exit=Button(root2,text="Exit",padx=5,bg="plum3",cursor="hand2",width=10,relief=RIDGE,borderwidth=1,font=('verdana',13,'bold'))
    Exit.place(x=270,y=290)
    if(len(varname.get())>0):
        print(varname.get())
        print(languages.get())
    root2.mainloop()

root=tk.Tk()
root.title("Quick Translator")
canvas=tk.Canvas(root,height=380,width=430,bg="white")
canvas.pack()
titleFont = font.Font(family='Lato Heavy',size=27, weight='bold')

label=Label(canvas,text='Quick Translator',bd=1,fg='black',font=titleFont,bg='white')
label.place(x=70,y=20)

img = ImageTk.PhotoImage(Image.open('/home/krutika/Python_stuff/Translate_logo.png'))
tile = Label(canvas, image = img)
tile.image = img
tile.place(x=110,y=85,height=184,width=185)

ImgTrans=Button(canvas,text="Image Translate",padx=5,bg="plum3",cursor="hand2",relief=RIDGE,borderwidth=1,font=('verdana',13,'bold') ,command=Image_Translate)
ImgTrans.place(x=18,y=290)

ImgTrans=Button(canvas,text="Text Translate",padx=5,bg="plum3",cursor="hand2",relief=RIDGE,borderwidth=1,font=('verdana',13,'bold'),command=Text_Translate)
ImgTrans.place(x=235,y=290)

root.mainloop()
