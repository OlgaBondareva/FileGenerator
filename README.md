### FileGenerator  

This program can perform several tasks:  
1. Create 100 text files with 100 000 strings and certain structure:  
random data for the past 5 years || 10 random latin symbols || 10 random russian symbols || random even positive integer in range (1, 100 000 000) || random positive number with 8 decimal places in range (1, 20) 
Example:  
`03.03.2015||ZAwRbpGUiK||мДМЮаНкуКД||14152932||7,87742021||`  
`23.01.2015||vgHKThbgrP||ЛДКХысХшЗЦ||35085588||8,49822372||`  
`17.10.2017||AuTVNvaGRB||мЧепрИецрА||34259646||17,7248118||`  
`24.09.2014||ArIAASwOnE||ЧпЙМдШлыфУ||23252734||14,6239438||`  
`16.10.2017||eUkiAhUWmZ||ЗэЖЫзЯШАэШ||27831190||8,10838026||` 

2. Merging files into one. While merging it's possible to remove lines with a given combination of characters, f.e. "abc",  
with number of deleted lines.  

3. Import files with such fields into a database.  Program also shows a progress while importing files.  
