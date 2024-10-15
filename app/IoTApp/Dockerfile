# Use the official ASP.NET Core runtime as a parent image
FROM mcr.microsoft.com/dotnet/aspnet:8.0 AS base
WORKDIR /app
EXPOSE 80

# Use the SDK image to build the application
FROM mcr.microsoft.com/dotnet/sdk:8.0 AS build
WORKDIR /src
COPY ["IoTApp.csproj", "./"]
RUN dotnet restore "./IoTApp.csproj"
COPY . .
WORKDIR "/src/."
RUN dotnet build "IoTApp.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "IoTApp.csproj" -c Release -o /app/publish

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "IoTApp.dll"]
