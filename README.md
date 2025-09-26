# 🛒 ProductScraper – E-commerce Product Data Extractor (Console Version)

This project is **Task 4** for the SkillCraft Technology **Software Development Internship**.

---

## 📝 Description
This Java program, named **ProductScraper**, extracts product information from a publicly accessible e-commerce website (**Books to Scrape**) and saves the data in a **CSV file**.  
The program fetches **Title, Price, and Availability** of products and formats them neatly for further use.

---

## 🎯 Features
- 🖥️ **Console Version**: Runs from command line  
- 💾 **CSV Output**: Stores product data in `products.csv` in a table format  
- 🔢 Extracts **Title, Price, Availability** for each product  
- ⚠️ Input & output validation ensures clean and usable data  
- 🧑‍💻 User-friendly: Simply run the program and data is saved automatically  

---

## 🚀 How to Run
Compile & Run:
```bash
javac ProductScraper.java
java ProductScraper
The program connects to http://books.toscrape.com/

Fetches product data from the main page

Saves output as products.csv in the same directory

📸 Sample CSV Output
Title	                                    Price	  Availability
A Light in the Attic	                    £51.77	In stock
Tipping the Velvet	                      £53.74	In stock
Soumission	                              £50.10	In stock
Sharp Objects	                            £47.82	In stock
Sapiens: A Brief History of Humankind	    £54.23	In stock
The Requiem Red	                          £22.65	In stock
```

```
📂 Project Structure
bash
Copy code
SCT_SD_4/
│-- ProductScraper.java    # Java program for scraping product data
│-- products.csv           # Output CSV file containing scraped products
│-- README.md              # Project documentation

```


🌱 Skills Practiced
Java programming fundamentals (HTTP requests, string manipulation, regex)

Parsing HTML content without external libraries

Writing structured CSV files in Java

Console-driven user-friendly programs

Using Git & GitHub for version control

👨‍💻 Author
Harry Jindal – Software Development Intern at SkillCraft Technology