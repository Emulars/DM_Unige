CREATE DATABASE IoTApp;
GO

USE [IoTApp]
GO
/****** Object:  Table [dbo].[__EFMigrationsHistory]    Script Date: 27/06/2024 16:39:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[__EFMigrationsHistory](
	[MigrationId] [nvarchar](150) NOT NULL,
	[ProductVersion] [nvarchar](32) NOT NULL,
 CONSTRAINT [PK___EFMigrationsHistory] PRIMARY KEY CLUSTERED 
(
	[MigrationId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[AspNetRoleClaims]    Script Date: 27/06/2024 16:39:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AspNetRoleClaims](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[RoleId] [nvarchar](450) NOT NULL,
	[ClaimType] [nvarchar](max) NULL,
	[ClaimValue] [nvarchar](max) NULL,
 CONSTRAINT [PK_AspNetRoleClaims] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[AspNetRoles]    Script Date: 27/06/2024 16:39:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AspNetRoles](
	[Id] [nvarchar](450) NOT NULL,
	[Name] [nvarchar](256) NULL,
	[NormalizedName] [nvarchar](256) NULL,
	[ConcurrencyStamp] [nvarchar](max) NULL,
 CONSTRAINT [PK_AspNetRoles] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[AspNetUserClaims]    Script Date: 27/06/2024 16:39:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AspNetUserClaims](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[UserId] [nvarchar](450) NOT NULL,
	[ClaimType] [nvarchar](max) NULL,
	[ClaimValue] [nvarchar](max) NULL,
 CONSTRAINT [PK_AspNetUserClaims] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[AspNetUserRoles]    Script Date: 27/06/2024 16:39:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AspNetUserRoles](
	[UserId] [nvarchar](450) NOT NULL,
	[RoleId] [nvarchar](450) NOT NULL,
 CONSTRAINT [PK_AspNetUserRoles] PRIMARY KEY CLUSTERED 
(
	[UserId] ASC,
	[RoleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[AspNetUsers]    Script Date: 27/06/2024 16:39:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AspNetUsers](
	[Id] [nvarchar](450) NOT NULL,
	[UserName] [nvarchar](256) NULL,
	[NormalizedUserName] [nvarchar](256) NULL,
	[Email] [nvarchar](256) NULL,
	[NormalizedEmail] [nvarchar](256) NULL,
	[EmailConfirmed] [bit] NOT NULL,
	[PasswordHash] [nvarchar](max) NULL,
	[SecurityStamp] [nvarchar](max) NULL,
	[ConcurrencyStamp] [nvarchar](max) NULL,
	[PhoneNumber] [nvarchar](max) NULL,
	[PhoneNumberConfirmed] [bit] NOT NULL,
	[TwoFactorEnabled] [bit] NOT NULL,
	[LockoutEnd] [datetimeoffset](7) NULL,
	[LockoutEnabled] [bit] NOT NULL,
	[AccessFailedCount] [int] NOT NULL,
 CONSTRAINT [PK_AspNetUsers] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DrivingSchool]    Script Date: 27/06/2024 16:39:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DrivingSchool](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Address] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Nation]    Script Date: 27/06/2024 16:39:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Nation](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ride]    Script Date: 27/06/2024 16:39:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ride](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Driver] [nvarchar](450) NOT NULL,
	[Instructor] [nvarchar](450) NOT NULL,
	[Vehicle] [int] NULL,
	[Prenotation] [datetime] NOT NULL,
	[StartRide] [datetime] NULL,
	[EndRide] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RideErrors]    Script Date: 27/06/2024 16:39:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RideErrors](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserNames]    Script Date: 27/06/2024 16:39:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserNames](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[User] [nvarchar](450) NOT NULL,
	[Name] [nvarchar](35) NOT NULL,
	[Surname] [nvarchar](35) NOT NULL,
	[Birthday] [date] NOT NULL,
	[Nationality] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserRideError]    Script Date: 27/06/2024 16:39:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserRideError](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[User] [nvarchar](450) NOT NULL,
	[Ride] [int] NOT NULL,
	[Error] [int] NOT NULL,
	[TimeStamp] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vehicle]    Script Date: 27/06/2024 16:39:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vehicle](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[PlateNumber] [nvarchar](7) NULL,
	[DrivingSchool] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VehicleData]    Script Date: 27/06/2024 16:39:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VehicleData](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[VehicleId] [int] NULL,
	[TimeStamp] [datetime] NULL,
	[Speed] [float] NULL,
	[Rpm] [float] NULL,
	[Throttle_pos] [float] NULL,
	[Battery_voltage] [float] NULL,
	[Transmission_temperature] [float] NULL,
	[Oil_temperature] [float] NULL,
	[Oil_pressure] [float] NULL,
	[Fuel_level] [float] NULL,
	[Fuel_consumption_rate] [float] NULL,
	[Latitude] [float] NULL,
	[Longitude] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[__EFMigrationsHistory] ([MigrationId], [ProductVersion]) VALUES (N'00000000000000_CreateIdentitySchema', N'8.0.1')
INSERT [dbo].[__EFMigrationsHistory] ([MigrationId], [ProductVersion]) VALUES (N'20240202112955_InitialCreate', N'8.0.1')
GO
INSERT [dbo].[AspNetRoles] ([Id], [Name], [NormalizedName], [ConcurrencyStamp]) VALUES (N'70a786e1-2b15-4a8f-ad58-5285e101ae22', N'Instructor', N'INSTRUCTOR', NULL)
INSERT [dbo].[AspNetRoles] ([Id], [Name], [NormalizedName], [ConcurrencyStamp]) VALUES (N'abd4f711-2b75-4374-9b72-e55507d413c9', N'Admin', N'ADMIN', NULL)
INSERT [dbo].[AspNetRoles] ([Id], [Name], [NormalizedName], [ConcurrencyStamp]) VALUES (N'bf089dcd-5922-42d6-8ea6-03f704ef05fc', N'Driver', N'DRIVER', NULL)
GO
INSERT [dbo].[AspNetUserRoles] ([UserId], [RoleId]) VALUES (N'f3f514da-f67d-4bf7-8754-7f47d3b96674', N'70a786e1-2b15-4a8f-ad58-5285e101ae22')
INSERT [dbo].[AspNetUserRoles] ([UserId], [RoleId]) VALUES (N'0b010aec-4c5c-4427-8a27-31e1f8aa6c8a', N'abd4f711-2b75-4374-9b72-e55507d413c9')
INSERT [dbo].[AspNetUserRoles] ([UserId], [RoleId]) VALUES (N'47e1e8bf-018c-40a3-94c6-142e69fe012d', N'bf089dcd-5922-42d6-8ea6-03f704ef05fc')
GO
INSERT [dbo].[AspNetUsers] ([Id], [UserName], [NormalizedUserName], [Email], [NormalizedEmail], [EmailConfirmed], [PasswordHash], [SecurityStamp], [ConcurrencyStamp], [PhoneNumber], [PhoneNumberConfirmed], [TwoFactorEnabled], [LockoutEnd], [LockoutEnabled], [AccessFailedCount]) VALUES (N'0b010aec-4c5c-4427-8a27-31e1f8aa6c8a', N'admin@admin.com', N'ADMIN@ADMIN.COM', N'admin@admin.com', N'ADMIN@ADMIN.COM', 0, N'AQAAAAIAAYagAAAAEHoS77yCyHn5E91ehFWn3pasrfNix81oyCVApiL7FCdNLDAm1n9szmhRUxNsbcOtVg==', N'3SNL6ISHPUJD43CZRWPOPW2GNRRZWTQT', N'2b44a720-1385-4373-ac88-3690e11f6bb8', NULL, 0, 0, NULL, 1, 0)
INSERT [dbo].[AspNetUsers] ([Id], [UserName], [NormalizedUserName], [Email], [NormalizedEmail], [EmailConfirmed], [PasswordHash], [SecurityStamp], [ConcurrencyStamp], [PhoneNumber], [PhoneNumberConfirmed], [TwoFactorEnabled], [LockoutEnd], [LockoutEnabled], [AccessFailedCount]) VALUES (N'47e1e8bf-018c-40a3-94c6-142e69fe012d', N'prova@prova.prova', N'PROVA@PROVA.PROVA', N'prova@prova.prova', N'PROVA@PROVA.PROVA', 0, N'AQAAAAIAAYagAAAAEJy0HuX1ljQ/UycUR9V9z//Rgq1tRQQ/sRHw0ABf2mEikjKQpifqFPZCS+p6q9bekw==', N'N7UEWL4R4RDQITQATFVSYPHG3Q655OG4', N'878df698-7160-41f5-a888-0375b93b2b94', NULL, 0, 0, NULL, 1, 0)
INSERT [dbo].[AspNetUsers] ([Id], [UserName], [NormalizedUserName], [Email], [NormalizedEmail], [EmailConfirmed], [PasswordHash], [SecurityStamp], [ConcurrencyStamp], [PhoneNumber], [PhoneNumberConfirmed], [TwoFactorEnabled], [LockoutEnd], [LockoutEnabled], [AccessFailedCount]) VALUES (N'f3f514da-f67d-4bf7-8754-7f47d3b96674', N'istruttore@i.com', N'ISTRUTTORE@I.COM', N'istruttore@i.com', N'ISTRUTTORE@I.COM', 0, N'AQAAAAIAAYagAAAAEKFLRBlZl0NxVXiTxMO85Oi9qxlmBmnqyqChatzBPkvifu1XOjHko+dyZ39Twr/8lg==', N'2YJ4WZ4URVPEGIS2HQ2S4IU343FHT4LB', N'e9cf8b58-ac88-46e1-b28f-350ceb11a98f', NULL, 0, 0, NULL, 1, 0)
GO
SET IDENTITY_INSERT [dbo].[DrivingSchool] ON 

INSERT [dbo].[DrivingSchool] ([Id], [Name], [Address]) VALUES (1, N'Draivo Corso Europa', N'C.so Europa, 161')
INSERT [dbo].[DrivingSchool] ([Id], [Name], [Address]) VALUES (2, N'Draivo Bobbio', N'Via Bobbio, 88r ')
SET IDENTITY_INSERT [dbo].[DrivingSchool] OFF
GO
SET IDENTITY_INSERT [dbo].[Nation] ON 

INSERT [dbo].[Nation] ([Id], [Name]) VALUES (1, N'Italy')
INSERT [dbo].[Nation] ([Id], [Name]) VALUES (2, N'Africa')
INSERT [dbo].[Nation] ([Id], [Name]) VALUES (3, N'Russia')
INSERT [dbo].[Nation] ([Id], [Name]) VALUES (4, N'China')
INSERT [dbo].[Nation] ([Id], [Name]) VALUES (5, N'America')
SET IDENTITY_INSERT [dbo].[Nation] OFF
GO
SET IDENTITY_INSERT [dbo].[Ride] ON 

INSERT [dbo].[Ride] ([Id], [Driver], [Instructor], [Vehicle], [Prenotation], [StartRide], [EndRide]) VALUES (4, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', N'f3f514da-f67d-4bf7-8754-7f47d3b96674', 3, CAST(N'2024-06-20T11:25:00.000' AS DateTime), CAST(N'2024-06-20T11:28:53.223' AS DateTime), CAST(N'2024-06-20T11:32:27.680' AS DateTime))
INSERT [dbo].[Ride] ([Id], [Driver], [Instructor], [Vehicle], [Prenotation], [StartRide], [EndRide]) VALUES (5, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', N'f3f514da-f67d-4bf7-8754-7f47d3b96674', 3, CAST(N'2024-06-21T11:50:00.000' AS DateTime), CAST(N'2024-06-21T12:09:51.293' AS DateTime), CAST(N'2024-06-21T12:10:37.230' AS DateTime))
INSERT [dbo].[Ride] ([Id], [Driver], [Instructor], [Vehicle], [Prenotation], [StartRide], [EndRide]) VALUES (6, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', N'f3f514da-f67d-4bf7-8754-7f47d3b96674', 3, CAST(N'2024-06-21T16:41:00.000' AS DateTime), CAST(N'2024-06-21T16:42:32.777' AS DateTime), CAST(N'2024-06-21T16:42:59.147' AS DateTime))
INSERT [dbo].[Ride] ([Id], [Driver], [Instructor], [Vehicle], [Prenotation], [StartRide], [EndRide]) VALUES (7, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', N'f3f514da-f67d-4bf7-8754-7f47d3b96674', 3, CAST(N'2024-06-23T14:48:00.000' AS DateTime), CAST(N'2024-06-23T14:49:38.130' AS DateTime), CAST(N'2024-06-23T14:50:06.067' AS DateTime))
INSERT [dbo].[Ride] ([Id], [Driver], [Instructor], [Vehicle], [Prenotation], [StartRide], [EndRide]) VALUES (8, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', N'f3f514da-f67d-4bf7-8754-7f47d3b96674', 3, CAST(N'2024-06-24T21:31:00.000' AS DateTime), CAST(N'2024-06-24T22:15:18.100' AS DateTime), CAST(N'2024-06-24T22:15:22.433' AS DateTime))
INSERT [dbo].[Ride] ([Id], [Driver], [Instructor], [Vehicle], [Prenotation], [StartRide], [EndRide]) VALUES (9, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', N'f3f514da-f67d-4bf7-8754-7f47d3b96674', NULL, CAST(N'2024-06-25T21:31:00.000' AS DateTime), NULL, NULL)
INSERT [dbo].[Ride] ([Id], [Driver], [Instructor], [Vehicle], [Prenotation], [StartRide], [EndRide]) VALUES (10, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', N'f3f514da-f67d-4bf7-8754-7f47d3b96674', 3, CAST(N'2024-06-24T21:42:00.000' AS DateTime), CAST(N'2024-06-24T21:55:03.983' AS DateTime), CAST(N'2024-06-24T21:56:11.283' AS DateTime))
INSERT [dbo].[Ride] ([Id], [Driver], [Instructor], [Vehicle], [Prenotation], [StartRide], [EndRide]) VALUES (11, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', N'f3f514da-f67d-4bf7-8754-7f47d3b96674', NULL, CAST(N'2024-06-29T21:53:00.000' AS DateTime), NULL, NULL)
SET IDENTITY_INSERT [dbo].[Ride] OFF
GO
SET IDENTITY_INSERT [dbo].[RideErrors] ON 

INSERT [dbo].[RideErrors] ([Id], [Name]) VALUES (1, N'Crossing')
INSERT [dbo].[RideErrors] ([Id], [Name]) VALUES (2, N'Precedence')
INSERT [dbo].[RideErrors] ([Id], [Name]) VALUES (3, N'Stop')
INSERT [dbo].[RideErrors] ([Id], [Name]) VALUES (4, N'Sidewalk')
SET IDENTITY_INSERT [dbo].[RideErrors] OFF
GO
SET IDENTITY_INSERT [dbo].[UserNames] ON 

INSERT [dbo].[UserNames] ([Id], [User], [Name], [Surname], [Birthday], [Nationality]) VALUES (1, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', N'Studente', N'Prova', CAST(N'1999-06-05' AS Date), 1)
INSERT [dbo].[UserNames] ([Id], [User], [Name], [Surname], [Birthday], [Nationality]) VALUES (2, N'f3f514da-f67d-4bf7-8754-7f47d3b96674', N'Istruttore', N'Prova', CAST(N'1987-05-02' AS Date), 5)
SET IDENTITY_INSERT [dbo].[UserNames] OFF
GO
SET IDENTITY_INSERT [dbo].[UserRideError] ON 

INSERT [dbo].[UserRideError] ([Id], [User], [Ride], [Error], [TimeStamp]) VALUES (1, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', 4, 1, CAST(N'2024-06-20T11:31:07.787' AS DateTime))
INSERT [dbo].[UserRideError] ([Id], [User], [Ride], [Error], [TimeStamp]) VALUES (2, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', 4, 2, CAST(N'2024-06-20T11:32:17.500' AS DateTime))
INSERT [dbo].[UserRideError] ([Id], [User], [Ride], [Error], [TimeStamp]) VALUES (3, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', 4, 3, CAST(N'2024-06-20T11:32:18.287' AS DateTime))
INSERT [dbo].[UserRideError] ([Id], [User], [Ride], [Error], [TimeStamp]) VALUES (4, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', 4, 4, CAST(N'2024-06-20T11:32:19.017' AS DateTime))
INSERT [dbo].[UserRideError] ([Id], [User], [Ride], [Error], [TimeStamp]) VALUES (5, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', 4, 2, CAST(N'2024-06-20T11:32:19.843' AS DateTime))
INSERT [dbo].[UserRideError] ([Id], [User], [Ride], [Error], [TimeStamp]) VALUES (6, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', 5, 1, CAST(N'2024-06-21T12:10:15.093' AS DateTime))
INSERT [dbo].[UserRideError] ([Id], [User], [Ride], [Error], [TimeStamp]) VALUES (7, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', 5, 2, CAST(N'2024-06-21T12:10:15.613' AS DateTime))
INSERT [dbo].[UserRideError] ([Id], [User], [Ride], [Error], [TimeStamp]) VALUES (8, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', 5, 3, CAST(N'2024-06-21T12:10:16.313' AS DateTime))
INSERT [dbo].[UserRideError] ([Id], [User], [Ride], [Error], [TimeStamp]) VALUES (9, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', 5, 2, CAST(N'2024-06-21T12:10:17.013' AS DateTime))
INSERT [dbo].[UserRideError] ([Id], [User], [Ride], [Error], [TimeStamp]) VALUES (10, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', 5, 4, CAST(N'2024-06-21T12:10:17.397' AS DateTime))
INSERT [dbo].[UserRideError] ([Id], [User], [Ride], [Error], [TimeStamp]) VALUES (11, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', 5, 2, CAST(N'2024-06-21T12:10:18.340' AS DateTime))
INSERT [dbo].[UserRideError] ([Id], [User], [Ride], [Error], [TimeStamp]) VALUES (12, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', 7, 2, CAST(N'2024-06-23T14:49:59.450' AS DateTime))
INSERT [dbo].[UserRideError] ([Id], [User], [Ride], [Error], [TimeStamp]) VALUES (13, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', 7, 3, CAST(N'2024-06-23T14:50:00.367' AS DateTime))
INSERT [dbo].[UserRideError] ([Id], [User], [Ride], [Error], [TimeStamp]) VALUES (14, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', 7, 1, CAST(N'2024-06-23T14:50:00.953' AS DateTime))
INSERT [dbo].[UserRideError] ([Id], [User], [Ride], [Error], [TimeStamp]) VALUES (15, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', 7, 4, CAST(N'2024-06-23T14:50:01.753' AS DateTime))
INSERT [dbo].[UserRideError] ([Id], [User], [Ride], [Error], [TimeStamp]) VALUES (16, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', 7, 4, CAST(N'2024-06-23T14:50:02.363' AS DateTime))
INSERT [dbo].[UserRideError] ([Id], [User], [Ride], [Error], [TimeStamp]) VALUES (17, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', 7, 1, CAST(N'2024-06-23T14:50:03.877' AS DateTime))
INSERT [dbo].[UserRideError] ([Id], [User], [Ride], [Error], [TimeStamp]) VALUES (18, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', 10, 1, CAST(N'2024-06-24T21:56:05.343' AS DateTime))
INSERT [dbo].[UserRideError] ([Id], [User], [Ride], [Error], [TimeStamp]) VALUES (19, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', 10, 2, CAST(N'2024-06-24T21:56:06.080' AS DateTime))
INSERT [dbo].[UserRideError] ([Id], [User], [Ride], [Error], [TimeStamp]) VALUES (20, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', 10, 4, CAST(N'2024-06-24T21:56:06.653' AS DateTime))
INSERT [dbo].[UserRideError] ([Id], [User], [Ride], [Error], [TimeStamp]) VALUES (21, N'47e1e8bf-018c-40a3-94c6-142e69fe012d', 10, 3, CAST(N'2024-06-24T21:56:07.270' AS DateTime))
SET IDENTITY_INSERT [dbo].[UserRideError] OFF
GO
SET IDENTITY_INSERT [dbo].[Vehicle] ON 

INSERT [dbo].[Vehicle] ([Id], [PlateNumber], [DrivingSchool]) VALUES (3, N'AB796BX', 1)
INSERT [dbo].[Vehicle] ([Id], [PlateNumber], [DrivingSchool]) VALUES (4, N'EX478HT', 2)
SET IDENTITY_INSERT [dbo].[Vehicle] OFF
GO
ALTER TABLE [dbo].[AspNetRoleClaims]  WITH CHECK ADD  CONSTRAINT [FK_AspNetRoleClaims_AspNetRoles_RoleId] FOREIGN KEY([RoleId])
REFERENCES [dbo].[AspNetRoles] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[AspNetRoleClaims] CHECK CONSTRAINT [FK_AspNetRoleClaims_AspNetRoles_RoleId]
GO
ALTER TABLE [dbo].[AspNetUserClaims]  WITH CHECK ADD  CONSTRAINT [FK_AspNetUserClaims_AspNetUsers_UserId] FOREIGN KEY([UserId])
REFERENCES [dbo].[AspNetUsers] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[AspNetUserClaims] CHECK CONSTRAINT [FK_AspNetUserClaims_AspNetUsers_UserId]
GO
ALTER TABLE [dbo].[AspNetUserRoles]  WITH CHECK ADD  CONSTRAINT [FK_AspNetUserRoles_AspNetRoles_RoleId] FOREIGN KEY([RoleId])
REFERENCES [dbo].[AspNetRoles] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[AspNetUserRoles] CHECK CONSTRAINT [FK_AspNetUserRoles_AspNetRoles_RoleId]
GO
ALTER TABLE [dbo].[AspNetUserRoles]  WITH CHECK ADD  CONSTRAINT [FK_AspNetUserRoles_AspNetUsers_UserId] FOREIGN KEY([UserId])
REFERENCES [dbo].[AspNetUsers] ([Id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[AspNetUserRoles] CHECK CONSTRAINT [FK_AspNetUserRoles_AspNetUsers_UserId]
GO
ALTER TABLE [dbo].[Ride]  WITH CHECK ADD FOREIGN KEY([Driver])
REFERENCES [dbo].[AspNetUsers] ([Id])
GO
ALTER TABLE [dbo].[Ride]  WITH CHECK ADD FOREIGN KEY([Instructor])
REFERENCES [dbo].[AspNetUsers] ([Id])
GO
ALTER TABLE [dbo].[Ride]  WITH CHECK ADD FOREIGN KEY([Vehicle])
REFERENCES [dbo].[Vehicle] ([Id])
GO
ALTER TABLE [dbo].[UserNames]  WITH CHECK ADD FOREIGN KEY([Nationality])
REFERENCES [dbo].[Nation] ([Id])
GO
ALTER TABLE [dbo].[UserNames]  WITH CHECK ADD FOREIGN KEY([User])
REFERENCES [dbo].[AspNetUsers] ([Id])
GO
ALTER TABLE [dbo].[UserRideError]  WITH CHECK ADD FOREIGN KEY([Error])
REFERENCES [dbo].[RideErrors] ([Id])
GO
ALTER TABLE [dbo].[UserRideError]  WITH CHECK ADD FOREIGN KEY([Ride])
REFERENCES [dbo].[Ride] ([Id])
GO
ALTER TABLE [dbo].[Vehicle]  WITH CHECK ADD  CONSTRAINT [FK_Vehicle_DrivingSchool] FOREIGN KEY([DrivingSchool])
REFERENCES [dbo].[DrivingSchool] ([Id])
GO
ALTER TABLE [dbo].[Vehicle] CHECK CONSTRAINT [FK_Vehicle_DrivingSchool]
GO
ALTER TABLE [dbo].[VehicleData]  WITH CHECK ADD FOREIGN KEY([VehicleId])
REFERENCES [dbo].[Vehicle] ([Id])
GO
