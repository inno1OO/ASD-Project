## Table of Contents

- [Installation](#installation)
- [Problem Statement](#problem-statement)
- [Architecture](#architecture)
- [Class Diagram](#class-diagram)
- [ER Diagram](#er-diagram)

## Installation

Instructions on how to install and set up the project:

1. Clone the repository
   ```sh
   git clone https://github.com/inno1OO/asd-project.git


## Problem Statement
After a 40 days of fasting, a group of young Christian decided to create a group of prayer called TryJesus Ministry, our goal is to spread the word of God to the max living being possible. When we started, we were less than 20. Now the community is growing so fast that it becomes mandatory to manage members data dynamically. Now we do everything using excel or on paper. We only have an app that help us to manage the tithes and offering. We want to manage members data. For every member, we want to know their name, address, email, phone number, their pair (because every member have a prayer partner). The members must be able to manage their devotion history, send their devotion, and eventually edit them. The members must receive notification on daily basis to remind them to do their devotion. 
The system must be able to manage the meetings link, we have weekly prayer on zoom, each prayer session is recorded, and we share the recording link so anyone who was not present can watch them anytime. So we need a system to manage these links, the users will be able to search a link by date or by the preach subject. We need to categorize each meeting, because not every meeting have the same purpose, we often have formation on specific subject. We have a lot of needs, but we want to address them gradually. As of today, we need to give to everyone the abtility to manage their devotion, like add a new one, update it and delete it in some case. It will be great if the app give the leader the ability to publish event so everyone can be aware of the upcoming events.


## Requirements Analysis
Authentication and Authorization:
The system must be able to define and make sure each role has access to their related ressources. Anyone can create an account, by default they will have the MEMBER Role. We only have two (Admin and Member)

Devotion Management:
Add, update, and delete devotion information. Every member will have the power to manage their own devotions and see others devotions.

Prayer Request Management:
Create, update, and remove a Prayer Request. Since we're a christian community, the problem of one is the problem of everyone. Each member will have the possibility to ask for prayer help. The member or the admin can change the status of this prayer request once God provide the answer.

Testimony:
Create, update, and remove a Testimony. A testimony is one of the best way to preach. We encourage our members to share their story to bless others.

Event
Create, update, and remove an event. The admin only will have the power to manage the events. The members will be able to see them. 

Offering
CRUD operation on an offering. The offering is not mandatory, but we encorage anyone who want to do so... while we will not manage them in the version 1 of the app, we wanted to introduce it for testing purpose.


## Architecture
![tryJesus](https://github.com/inno1OO/ASD-Project/assets/36110389/1905b9ca-57a7-469f-acd0-11da13830c15)


## Class Diagram

![image](https://github.com/inno1OO/ASD-Project/assets/36110389/557474aa-7ef0-4639-ad6b-10bd31e1f212)

## ER Diagram
![er diagram](https://github.com/inno1OO/ASD-Project/assets/36110389/d4c1b942-de03-462e-8d6d-6cf6ddc1b006)

