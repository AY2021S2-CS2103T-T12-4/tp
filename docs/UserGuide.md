---
layout: page
title: imPoster User Guide
nav-text: User Guide
---

<p align="center">
  <img width="300px" src="images/imPosterUserGuide.png" >
</p>

<h1 class="post-title">{{ page.title | escape }}</h1>
<h3 class="post-subtitle">v1.3</h3>

<div style="page-break-after: always;"></div>
<br/>

## Table of Contents
{:.no_toc}

* Table of Contents 
{:toc}

<div style="page-break-after: always;"></div>

## 1. Welcome to imPoster

Are you an aspiring [**Application Programming Interface (API)**](#7-glossary) developer? Or would you like a peek into the world of how applications communicate with one another? Then **imPoster** is the app just for you! But hold on, what is imPoster?

imPoster is a desktop application for beginners of API development to quickly go hands-on with the basics. Whether you are looking to **explore**, **test**, or **build** your very own APIs, the simple and minimalistic style of imPoster will quickly get you up and going.

This user guide assumes that users have a **basic understanding** of APIs. If you are wondering [what an API is](#81-what-is-an-api), an appendix has been provided for users who may be unfamiliar with the concept. However, it is highly recommended for users to refer to proper tutorial contents for the basics of APIs prior to using the application.

For fast typists, imPoster is also highly optimised for the command line and can be fully operated through keyboard commands. Users who are familiar with [**CURL**](#7-glossary) will also be happy to know that we share a very similar command line syntax. If you have yet to do so, be sure to download our [latest releases](https://imposter-dev.tk) from our main website and give us a try!

<div style="page-break-after: always;"></div>

## 2. Navigating the User Guide

Before diving into the rest of the contents in our user guide, the following are some important syntax to take note of to facilitate your reading:

| Syntax              | Description                                    |
| ------------------- | ---------------------------------------------- |
| **Bold**            | Important words to note                        |
| `Markdown`          | Important examples                             |
| <kbd>Keyboard</kbd> | Keyboard actions                               |
| <div markdown="span" class="alert alert-warning custom-table-format">:bulb: Tips</div> | Useful tips |
| <div markdown="span" class="alert alert-danger custom-table-format">:exclamation: Caution</div> | Things to watch out for |
| <span class="main-command">Main Command</span> | Indicates the keyword describing the main action of a command |
| <span class="compulsory-param">Compulsory Parameter</span> | Indicates the compulsory parameters/prefixes of a command |
| <span class="optional-param">Optional Parameter</span> | Indicates the optional parameters/prefixes of a command |
| [Repeated Parameters]   | Indicates the parameters/prefixes that may be repeated multiple times    |


<div style="page-break-after: always;"></div>

## 3. Quickstart

1. Ensure you have **Java 11 or above** installed in your Computer.

2. Download the latest **imposter.jar** from
   [here](https://github.com/AY2021S2-CS2103T-T12-4/tp/releases) and move the file to the folder you wish to use as the **home folder** for imPoster.

4. **Double-click** the file to start the application. A graphical user interface (GUI) containing the annotated **3 main components** should show up as below:<br>

    <p align="center">
      <img width="900px" src="images/startscreen.png" >
    </p>

5. Try making your first API call through our application with the first [**endpoint**](#7-glossary) shown in the 
   sample **Endpoint List**. Type <span class="main-command">send</span> <span class="compulsory-param">1</span> in 
   the **Command Box** and then press <kbd>Enter</kbd>.

6. After which, try scrolling through the responses shown in the **Result Display** as well!

7. For a quick **overview** of all available commands, please refer to our [Command Summary](#6-command-summary).

8. For the **details** of each command, please proceed to the next section on [Commands](#4-commands).

9. When you are ready to start testing your APIs, remove the sample **Endpoint List** by typing <span 
   class="main-command">clear</span> in the **Command Box** and then press <kbd>Enter</kbd>.
   
**Note:** imPoster data are saved automatically into a JSON file `<JAR file location>/data/imposter.json` after any command that changes the data.

<div markdown="span" class="alert alert-danger">:exclamation: **Caution:**
imPoster will start with an empty file if a modification to the data file causes the data to be invalid.
</div>

<div style="page-break-after: always;"></div>

## 4. Commands

Commands are classified into 2 categories, namely **general** and **endpoint**. Before diving into the details, let us first look at what makes up a command:

| Component    | Description                                                           |
| ------------ | --------------------------------------------------------------------- |
| Command Word | The keyword representing the action of the command                    |
| Prefix       | The keyword to recognise command parameters                           |
| Parameters   | Follows directly behind a prefix and contains the corresponding value |

As an example, a basic command to add an endpoint could look like the following:

<span class="main-command">add</span> <span class="compulsory-param">-x GET</span> <span class="compulsory-param">-u https://google.com</span>

In the example above, <span class="main-command">add</span> is the command word while <span class="compulsory-param">-x</span> and <span class="compulsory-param">-u</span> are the prefixes of the <span class="compulsory-param">GET</span> and <span class="compulsory-param">https://google.com</span> parameters respectively. Note that the parameters allowed differ for each command and may be optional. For your convenience, a list of all parameters along with their prefixes and descriptions have been included in the following table:

<a name="prefix-table"></a>

| Parameter    | Prefix | Description                                                           |
| ------------ | ------ | --------------------------------------------------------------------- |
| INDEX        |  None  | The index of the endpoint as shown in the endpoint panel list         |
| THEME        |  None  | The theme for the application                                         |
| METHOD       |   -x   | The [request method](#83-request-methods) to use for an endpoint      |
| ADDRESS      |   -u   | The URL to use for an endpoint                                        |
| HEADER       |   -h   | The header to use for an endpoint **(must be enclosed with "")**      |
| DATA         |   -d   | The data to use for an endpoint **(must be in JSON format)**          |
| TAG          |   -t   | The tag to label an endpoint                 |

<div markdown="span" class="alert alert-warning">:bulb: **Tip:**
Check out the screenshot of each command for an idea of the expected output in the application's **Result Display**!
</div>

<div style="page-break-after: always;"></div>

### 4.1 General

#### 4.1.1 View help: `help`

**Description:** Get the relevant helpful information such as the link to the user guide, and the command summary 
table in the form of a pop up window.

**Format:** <span class="main-command">help</span>

**Example & Output:** <span class="main-command">help</span>

<p align="center">
  <img width="450px" src="images/helpMessage.png" >
</p>

#### 4.1.2 Toggle theme: `toggle`

**Description:** Toggle the theme for the application **(light, dark, or imposter)**.

**Format:** <span class="main-command">toggle</span> <span class="compulsory-param">THEME</span>

**Example & Output:** <span class="main-command">toggle</span> <span class="compulsory-param">light</span>

<p align="center">
  <img width="450px" src="images/commands/toggle.png" >
</p>

<div style="page-break-after: always;"></div>

#### 4.1.3 Exit program: `exit`

**Description:** Exit the application.

**Format:** <span class="main-command">exit</span>

**Example:** <span class="main-command">exit</span>

### 4.2 Endpoint

#### 4.2.1 Add an API endpoint: `add`

**Description:** Add an API endpoint to the API endpoint list.

**Format:** <span class="main-command">add</span> <span class="compulsory-param">-x METHOD</span> <span class="compulsory-param">-u URL</span> <span class="optional-param">-d DATA</span> <span class="optional-param">[-h HEADER]</span> <span class="optional-param">[-t TAG]</span>

**Example & Output:** <span class="main-command">add</span> <span class="compulsory-param">-x POST</span> <span class="compulsory-param">-u https://reqres.in/api/users</span> <span class="optional-param">-d {"name": "tarzan", "job": "the jungle man"}</span> <span class="optional-param">-h "Content-Type: application/json"</span> <span class="optional-param">-t nature</span>

//to-do tanjin update picture
<p align="center">
  <img width="450px" src="images/commands/add.png" >
</p>

<div markdown="span" class="alert alert-danger">:exclamation: **Caution**
Multiple headers/tags must be unique and duplicates will be ignored
</div>

<div style="page-break-after: always;"></div>

#### 4.2.2 Edit an API endpoint: `edit`

**Description:** Edit the API endpoint at the specified index shown in the API endpoint list **(at least one optional argument must be provided)**.

**Format:** <span class="main-command">edit</span> <span class="compulsory-param">INDEX</span> <span class="optional-param">-x METHOD</span> <span class="optional-param">-u URL</span> <span class="optional-param">-d DATA</span> <span class="optional-param">[-h HEADER]</span> <span class="optional-param">[-t TAG]</span>

**Example & Output:** <span class="main-command">edit</span> <span class="compulsory-param">1</span> <span class="optional-param">-x POST</span> <span class="optional-param">-u https://reqres.in/api/users</span> <span class="optional-param">-d {"name": "john doe", "job": "developer"}</span>

<p align="center">
  <img width="450px" src="images/commands/edit.png" >
</p>

<div markdown="span" class="alert alert-warning">:bulb: **Tip:**
Multiple headers/tags must be unique and duplicates will be ignored
</div>

#### 4.2.3 Show an API endpoint: `show`

**Description:** Show the details of the API endpoint at the specified index shown in the API endpoint list (index must 
be a positive integer).

**Format:** <span class="main-command">show</span> <span class="compulsory-param">INDEX</span>

**Example & Output:** <span class="main-command">show</span> <span class="compulsory-param">1</span>

<p align="center">
  <img width="450px" src="images/commands/show.png" >
</p>

<div style="page-break-after: always;"></div>

#### 4.2.4 Remove an API endpoint: `remove`

**Description:** Remove the API endpoint at the specified index shown in the API endpoint list.

**Format:** <span class="main-command">remove</span> <span class="compulsory-param">INDEX</span>

**Example & Output:** <span class="main-command">remove</span> <span class="compulsory-param">1</span>

<p align="center">
  <img width="450px" src="images/commands/remove.png" >
</p>

#### 4.2.5 Find a saved API endpoint: `find`

**Description:** Find API routes containing the search word in any of its fields **(defaults to all fields if not specified and requires at least one keyword)**.

**Format:** <span class="main-command">find</span> <span class="optional-param">[KEYWORD]</span>

**Example & Output:** <span class="main-command">find</span> <span class="optional-param">github</span> <span class="optional-param">transport</span>

<p align="center">
  <img width="450px" src="images/commands/find.png" >
</p>

<div markdown="span" class="alert alert-warning">:bulb: **Tip:**
You may include [prefixes](#prefix-table) to scope your search terms!
</div>

<div style="page-break-after: always;"></div>

#### 4.2.6 List all saved API endpoints: `list`

**Description:** Show a list of all API endpoints in the API endpoint list.

**Format:** <span class="main-command">list</span>

**Example & Output:** <span class="main-command">list</span>

<p align="center">
  <img width="450px" src="images/commands/list.png" >
</p>

#### 4.2.7 Clear all saved API endpoints: `clear`

**Description:** Clear all API endpoints in the API endpoint list.

**Format:** <span class="main-command">clear</span>

**Example & Output:** <span class="main-command">clear</span>

<p align="center">
  <img width="450px" src="images/commands/clear.png" >
</p>

<div markdown="span" class="alert alert-warning">:bulb: **Tip:**
If you wish to generate a set of sample endpoints, you may delete the **imposter.json** file inside the **data** folder!
</div>

<div style="page-break-after: always;"></div>

#### 4.2.8 Call a saved API endpoint: `send`

**Description:** Call an API endpoint from the API endpoint list **(an ongoing call can be cancelled with <kbd>ctrl</kbd> + <kbd>d</kbd>)**.

**Format** <span class="main-command">send</span> <span class="compulsory-param">INDEX</span>

**Example & Output:** <span class="main-command">send</span> <span class="compulsory-param">1</span>

<p align="center">
  <img width="450px" src="images/commands/send.png" >
</p>

#### 4.2.9 Call an API endpoint directly without saving: `run`

**Description:** Call an API endpoint directly (without saving) **(an ongoing call can be cancelled with <kbd>ctrl</kbd> + <kbd>d</kbd>)**.

**Format:** <span class="main-command">run</span> <span class="compulsory-param">-x METHOD</span> <span class="compulsory-param">-u URL</span> <span class="optional-param">-d DATA</span> <span class="optional-param">[-h HEADER]</span>

**Example & Output:** <span class="main-command">run</span> <span class="compulsory-param">-x GET</span> <span class="compulsory-param">-u https://api.data.gov.sg/v1/environment/pm25</span>

<p align="center">
  <img width="450px" src="images/commands/run.png" >
</p>

<div markdown="span" class="alert alert-warning">:bulb: **Tip:**
A shorthand for <span class="compulsory-param">GET</span> requests can be done without specifying <span class="compulsory-param">-x</span> and <span class="compulsory-param">-u</span> (for example: <span class="main-command">run</span> <span class="compulsory-param">https://api.data.gov.sg/v1/environment/pm25</span>).
</div>

<div style="page-break-after: always;"></div>

### 4.3 Miscellaneous

#### 4.3.1 Retrieve the last valid command

**Description:** Given that the last valid command from a user is most likely to be repeated during the API development
& verification process, a special key combination <kbd>ctrl</kbd> + <kbd>up-arrow</kbd> (Windows) / <kbd>cmd</kbd> + 
<kbd>up-arrow</kbd> (Mac) is available to set the 
command box with the last command.

**Format:** <kbd>ctrl</kbd> + <kbd>up-arrow</kbd> (Windows) / <kbd>cmd</kbd> + <kbd>up-arrow</kbd> (Mac)

#### 4.3.2 Switch focused component

**Description:** As users may wish to switch the focused component (e.g. to type commands in the commandbox or to scroll responses in the result display), the <kbd>tab</kbd> key is available as an option to toggle the focused component (highlighted with an orange outline).

**Format:** <kbd>tab</kbd>

#### 4.3.3 Scroll endpoint list or result display

**Description:** As users may wish to scroll the endpoints in the endpoint list or the responses in result display, the <kbd>Page Up</kbd> and <kbd>Page Down</kbd> keys (<kbd>fn</kbd> + <kbd>up</kbd> and <kbd>fn</kbd> + <kbd>down</kbd> on **MacOS**) are available as options to scroll the 2 components above.

**Format:** <kbd>Page Up</kbd> and <kbd>Page Down</kbd> (<kbd>fn</kbd> + <kbd>up</kbd> and <kbd>fn</kbd> + <kbd>down</kbd> on **MacOS**)

## 5. FAQ

**Q**: How do I transfer my data to another Computer?<br> **A**: Install the
application in the other computer and overwrite the empty data file it creates
with the file that contains the data of your previous imPoster home folder.

**Q**: How can I send non-JSON data in the request body?<br> **A**: This current version of imPoster only supports the sending of [JSON](#84-json-format) data in the request body which is the format used by an estimated over 70% of APIs worldwide. We apologise for the inconvenience but rest assured that plans are in place to include support for other data formats in future versions.

{more to be added}

<div style="page-break-after: always;"></div>

## 6. Command summary

A quick overview of all supported commands, their formats and examples are given below:

### 6.1 General

| Command    | Format                                |
| ---------- | ------------------------------------- |
| **Help**   | `help`                                |
| **Toggle** | `toggle`                              |
| **Exit**   | `exit`                                |

### 6.2 Endpoint

| Command    | Format                                | 
| ---------- | ------------------------------------- |
| **Add**    | `add -x METHOD -u URL [-d DATA] [-h HEADER]… [-t TAG]…` <br>  |
| **Edit**   | `edit INDEX [-x METHOD] [-u URL] [-d DATA] [-h HEADER]… [-t TAG]…`<br> |
| **Show**   | `show INDEX`<br>                      |
| **Remove** | `remove INDEX`<br>                    |
| **Find**   | `find KEYWORD [MORE_KEYWORDS]…`<br> |
| **List**   | `list`                                |
| **Clear**  | `clear`                               |
| **Send**   | `send INDEX` <br>                     |
| **Run**    | `run -x METHOD -u URL [-d DATA] [-h HEADER]…` <br> |

<div style="page-break-after: always;"></div>

## 7. Glossary

| Term                                         | Description                                               |
| -------------------------------------------- | --------------------------------------------------------- |
| **API (Application Programming Interface)** | An interface for two systems to interact with each other  |
| **Endpoint** | The point of entry in a communication channel for two systems to interact with each other |
| **Request** | A process in which information is sent out to an endpoint through one of the [request methods](#83-request-methods) |
| **Response** | The information obtained from an endpoint after a request is sent to it (commonly in the [JSON format](#84-json-format)) |
| **Parameter**   | Information passed in as part of a command with its type identified by a prefix (e.g. <span class="compulsory-param">METHOD</span>) |
| **Prefix**   | Characters used to identify the following parameter (e.g. <span class="compulsory-param">-x</span> is the prefix for the parameter <span class="compulsory-param">METHOD</span>) |
| **JSON (JavaScript Object Notation)** | A lightweight format for data storage (a more detailed explanation can be found [here](#84-json-format)) |
| **CURL (Client URL)** | A command-line tool used in the transfer of data via different network protocols |
| **Index** | Index in this guide refers to the position of the endpoint in the endpoint list. It is signified by the number beside the endpoint. |

<div style="page-break-after: always;"></div>

## 8. Appendix

### 8.1 What is an API?

Broadly speaking, an **API** is an interface that enables and defines how **two systems** interact with one another. In a classic analogy, the interaction above is usually likened to a **waiter** communicating a **customer** order to the restaurant **kitchen**. In this analogy, the **customer** and **kitchen** represents the **two systems**, and the **waiter** represents the **API** allowing them to communicate. The **order** and **food** delivered then corresponds to the terms **request** and **response** associated with an API call. The annotated diagrams below capture these interactions and may aid in providing a better understanding:

<p align="center">
  <img width="700px" src="images/ApiExplanation.png" >
</p>

Note that for the **waiter** to pass the order to the **kitchen**, a **window/door** is required to allow communication and this is represented by the term [**endpoint**](#7-glossary) which is frequently used in relation to an API.

<div style="page-break-after: always;"></div>

### 8.2 Why learn about APIs?

You may be surprised to know that APIs are not only widely used in our daily lives, it is also likely that you have been using them frequently without actually noticing them! For example, the simple act of visiting a website involves an API request which is responsible for bringing back a response to you in the form of a webpage. Even a simple text message to your friend relies on an API to reliably deliver your message! The use of APIs is extensive in today’s highly connected world so even if they are completely unrelated to your job, it helps to have some basic understanding of them!

### 8.3 Request Methods
Officially, there are 39 HTTP methods but for the latest version of our application, only the 7 most common methods are supported. We recommend individuals who are interested to learn more about the request types to refer to official documentation even though a brief explanation for the 7 supported requests have been provided below:

| Method      | Description                                                                                                 |
| ----------- | ----------------------------------------------------------------------------------------------------------- |
| **GET**     | Retrieves information from a server through a specified URI (unable to modify server data)                  |
| **POST**    | Sends data to a server, commonly in JSON/html form format. (able to modify server data - create)            |
| **PUT**     | Sends data to a server, commonly in JSON/html form format. (able to modify server data - overwrite)         |
| **DELETE**  | Removes information from a server through a specified URI (able to modify server data - delete)             |
| **HEAD**    | Similar to GET, but returns only the header section of the response                                         |
| **PATCH**   | Sends data to a server, commonly in JSON/html form format. (able to modify server data - partial overwrite) |
| **OPTIONS** | Retrieves the allowed communication options (methods) for a specified URI                                   |

### 8.4 JSON Format
JSON is short for JavaScript Object Notation and is a common lightweight format for data storage. In an API call, the JSON format is also commonly used to send data between two systems. For the current version of our application, JSON is the only format supported for sending data. The following are some examples of data in JSON format:
- `{}`
- `{"name": "john doe"}`
- `{"persons": {"name": "john doe"}}`

### 8.5 Sample Endpoints

| Method      | URL                                                           | Data (JSON)                                       |
|-------------|---------------------------------------------------------------|---------------------------------------------------|
| **GET**     | http://imposter-dev.tk:6000/api/v1/resources/books/all        | N/A                                               |
| **GET**     | http://imposter-dev.tk:6000/api/v1/resources/books?id=1       | N/A                                               |
| **GET**     | https://project-billboard.herokuapp.com/laugh                 | N/A                                               |
| **GET**     | https://api.data.gov.sg/v1/environment/psi                    | N/A                                               |
| **GET**     | https://api.data.gov.sg/v1/environment/4-day-weather-forecast | N/A                                               |
| **GET**     | https://api.data.gov.sg/v1/environment/2-hour-weather-forecast| N/A                                               |
| **GET**     | https://api.data.gov.sg/v1/environment/rainfall               | N/A                                               |
| **GET**     | https://api.data.gov.sg/v1/environment/relative-humidity      | N/A                                               |
| **GET**     | https://api.data.gov.sg/v1/environment/wind-speed             | N/A                                               |
| **GET**     | https://api.data.gov.sg/v1/environment/wind-direction         | N/A                                               |
| **GET**     | https://api.data.gov.sg/v1/environment/air-temperature        | N/A                                               |
| **GET**     | https://api.data.gov.sg/v1/technology/ipos/trademarks         | N/A                                               |
| **GET**     | https://api.data.gov.sg/v1/technology/ipos/patents            | N/A                                               |
| **GET**     | https://api.data.gov.sg/v1/technology/ipos/designs            | N/A                                               |
| **GET**     | https://api.data.gov.sg/v1/transport/taxi-availability        | N/A                                               |
| **POST**    | https://jsonplaceholder.typicode.com/posts                    | title, body, userId                               |

