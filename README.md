# Selenium with Azure Blob Storage Integration

This project publishes Selenium test artifacts to an Azure Blob Storage account. 

## Prerequisites

Before running the tests locally, you need to set up the following:

- **Container Name**: Your Azure Blob Storage container name.
- **Account Name**: Your Azure Blob Storage account name.
- **Secret Key**: Your Azure Blob Storage secret key.

## Running Tests Locally

1. Set the secret key in your environment:
   ```bash
   export MY_SECRET_KEY="<Set The Key Here.>"
2. Run the tests using Maven:
   ```bash
     mvn test
