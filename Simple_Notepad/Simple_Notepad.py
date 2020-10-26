#!/usr/bin/env python3
from tkinter import *
import tkinter as tk
from tkinter import filedialog
from tkinter import messagebox,font,ttk
from tkinter.scrolledtext import ScrolledText
import webbrowser
from datetime import datetime
import os


def new():
    text.delete('1.0','end')

def new_window():
    #New window has samw design format as in main function

    root1=tk.Tk()
    root1.geometry('600x600')
    root1.title('Simple Notepade') 
    #root1.iconphoto(True, PhotoImage(file=os.path.join("/home/krutika/Pictures", "Notepad-icon.png")))
    menubar=Menu(root1)
    filemenu=Menu(menubar,tearoff=0)
    filemenu.add_command(label="New")
    filemenu.add_command(label="New Window")
    filemenu.add_command(label="Open")
    filemenu.add_command(label="Save")
    filemenu.add_command(label="Save As")
    filemenu.add_separator()
    filemenu.add_command(label="Exit")
    menubar.add_cascade(label="File",menu=filemenu,font=('Arial ',11,'bold'))
    
    edit=Menu(menubar,tearoff=0)
    edit.add_command(label="Undo",accelerator="Ctrl+Z")
    edit.add_separator()
    edit.add_command(label="Cut" ,accelerator="Ctrl+X")
    edit.add_command(label="Copy" ,accelerator="Ctrl+C")
    edit.add_command(label="Paste",accelerator="Ctrl+V")
    edit.add_command(label="Delete",accelerator="Del")
    edit.add_command(label="Select All",accelerator="Ctrl+A")
    edit.add_command(label="Time/Date",accelerator="F5")
    menubar.add_cascade(label="Edit",menu=edit,font=('Arial',11,'bold'))
    
    format_menu=Menu(menubar,tearoff=0)
    format_menu.add_command(label="Word Wrap")
    format_menu.add_command(label="Font..")
    menubar.add_cascade(label="Format",menu=format_menu,font=('Arial',11,'bold'))
    
    help=Menu(menubar,tearoff=0)
    help.add_command(label="Notepad Help")
    help.add_command(label="Send Feedback")
    help.add_command(label="About Notepad")
    menubar.add_cascade(label="Help",menu=help,font=('Arial',11,'bold'))
    
    root1.config(menu=menubar)
    text=ScrolledText(root1,width=1000,height=1000)
    text.place(x=0,y=0)
    root1.mainloop()

def Open():
    filename=""
    filename = filedialog.askopenfilename(initialdir = 'E:\\',title = 'Select File',filetypes = (('txt','*.txt'),('All files','*.*')))
    file=open(filename)
    text.insert('end',file.read())

def save():
    pass

def save_as():
    filename=""
    filename=filedialog.asksaveasfile(mode="w",defaultextension=' .txt')
    if filename==None:
        return
    file_saved=str(text.get(1.0,END))
    filename.write(file_saved)
    filename.close()

def exit():
    msg=messagebox.askquestion('Notepad',"Do you want to save changes")
    if msg=="yes":
        save_as()
    else:
        root.destroy()

def cut():
    text.event_generate("<<Cut>>")
def copy():
    text.event_generate("<<Copy>>")

def paste():
    text.event_generate("<<Paste>>")


def select_all():
    text.tag_add('sel','1.0','end')
    return 'break'

def time_date():
    date=datetime.now()
    text.insert('end',date)

def delete():
    msg=messagebox.askquestion('Notepad','Are u sure u want to delete everything?')
    if msg=="yes":
        text.delete('1.0','end')
    else:
        return 'break'

def get_fonts():

    # We create a seperate window for font selections
    root=tk.Tk()
    root.geometry('550x450')
    root.title('Select Font')

    li=Label(root,text="Available fonts :")
    li.place(x=10,y=10)

    f=tk.StringVar()
    fonts=ttk.Combobox(root,width=15,textvariable=f,state='readonly',font=('verdana',10,'bold'),)  # For Font Families
    fonts['values']=font.families()
    fonts.place(x=10,y=30)
    fonts.current(0)

    l2=Label(root,text="Font Style:")
    l2.place(x=200,y=10)
    st=tk.StringVar()
    style=ttk.Combobox(root,width=15,textvariable=st,state='readonly',font=('verdana',10,'bold'),)
    style['values']=('','bold','bold italic','italic') #Font styles
    style.place(x=200,y=30)
    style.current(0)

    l3=Label(root,text="Size")
    l3.place(x=370,y=10)
    size_var=tk.StringVar()
    SIZES=ttk.Combobox(root,width=15,textvariable=size_var,state='readonly',font=('verdana',10,'bold'),)  #For Font sizes
    SIZES['values']=('6','7','8','9','10','12','14','16','17','18','20','21','22','24','25','27','28','30','32','34','35','37','38','40','44','46','48','50','52','54','56','58','60','70','80','90')
    SIZES.place(x=370,y=30)
    SIZES.current(0)

    # Sampe text so the user gets to know about the effect of font styles selected
    sample=LabelFrame(root,text="Sample",height="200",width="360")
    sample['font']=(fonts.get(),SIZES.get(),style.get())
    sample.place(x=100,y=150)
    l4=Label(sample,text="Always Love Yourself !!")
    l4.place(x=20,y=30)

    def OK():
        text['font']=(fonts.get(),SIZES.get(),style.get())
        
    ok=Button(root,text="OK",fg="black",justify=CENTER,cursor="hand2",width=5,bd=1,bg="Cyan",command=OK,padx=20,pady=1,highlightcolor="blue").place(x=130,y=380)
    def Aply():
        l4['font']=(fonts.get(),SIZES.get(),style.get())

    Apply=Button(root,text="Apply",fg="black",justify=CENTER,cursor="hand2",width=5,bd=1,bg="Cyan",command=Aply,padx=20,pady=1,highlightcolor="blue").place(x=220,y=380)
    def Cancel():
        root.destroy()

    cancel=Button(root,text="Cancel",fg="black",justify=CENTER,cursor="hand2",width=5,bd=1,bg="cyan",command=Cancel,padx=20,pady=1,highlightcolor="blue").place(x=310,y=380)
    root.mainloop()

def help_fuction():
    top=Toplevel()
    top.wm_title("Help")
    top.minsize(200,200)
    top.geometry("550x300")
    text=Text(top,bg='white')
    text.insert('1.0',"Welcome \n1) On the Menubar you can find file menu.\n\tNew :Open a new file\n\tNew Window :Open a new Notepad application\n\tOpen :Select and open a new txt file\n\tSave/Save As :Save the txt file\n\n2) On edit menu:\nU can operate the function with key notations also\n\n3) On format menu,U can find Word Warp and Fonts.Select the Font-style,size..etc\nClick on Apply to apply the fonts to sample text and click on OK")
    text.place(relx = 0.05,rely = 0.1,relwidth =0.9,relheight =0.6)


# The notepad design
root=tk.Tk()
root.geometry('600x600')
root.title('Simple Notepade')
root.iconphoto(True, PhotoImage(file=os.path.join("/home/krutika/Python_stuff", "Notepad-icon.png")))

# Area for text region
text=ScrolledText(root,width=1000,height=1000,undo=True)
text.place(x=0,y=0)

#Add the menubar with all necessary functions
#File menu
menubar=Menu(root)
filemenu=Menu(menubar,tearoff=0)
filemenu.add_command(label="New",command=new)
filemenu.add_command(label="New Window", command=new_window)
filemenu.add_command(label="Open",command=Open)
filemenu.add_command(label="Save",command=save)
filemenu.add_command(label="Save As" ,command=save_as)
filemenu.add_separator()
filemenu.add_command(label="Exit",command=exit)
menubar.add_cascade(label="File",menu=filemenu,font=('Arial ',11,'bold'))

#Edit Menu
edit=Menu(menubar,tearoff=0)
edit.add_command(label="Undo",accelerator="Ctrl+Z",command=text.edit_undo)
edit.add_separator()
edit.add_command(label="Cut" ,accelerator="Ctrl+X",command=cut)
edit.add_command(label="Copy" ,accelerator="Ctrl+C",command=copy)
edit.add_command(label="Paste",accelerator="Ctrl+V",command=paste)
edit.add_command(label="Delete",accelerator="Del",command=delete)
edit.add_command(label="Select All",accelerator="Ctrl+A",command=select_all)
edit.add_command(label="Time/Date",accelerator="F5",command=time_date)
menubar.add_cascade(label="Edit",menu=edit,font=('Arial',11,'bold'))

#Formay menu
format_menu=Menu(menubar,tearoff=0)
format_menu.add_command(label="Word Wrap")
format_menu.add_command(label="Font..",command=get_fonts)
menubar.add_cascade(label="Format",menu=format_menu,font=('Arial',11,'bold'))

#Help Menu
help_=Menu(menubar,tearoff=0)
help_.add_command(label="Help",command=help_fuction)
help_.add_command(label="Send Feedback")
help_.add_command(label="About Notepad")
menubar.add_cascade(label="Help",menu=help_,font=('Arial',11,'bold'))
root.config(menu=menubar)

root.mainloop()
