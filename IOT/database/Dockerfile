# Use the official Microsoft SQL Server image as the base image
FROM mcr.microsoft.com/mssql/server:2019-latest

# Set environment variables
ENV ACCEPT_EULA=Y
ENV SA_PASSWORD=YourStrongPassw0rd

# Expose the SQL Server port
EXPOSE 1433

# Copy the SQL script to set up the database and tables
COPY setup.sql /setup.sql

# Run the SQL script after the container starts
CMD /opt/mssql/bin/sqlservr & sleep 30 && /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P YourStrongPassw0rd -i /setup.sql && wait
