/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.entity.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eggy03.cimari.rest.annotation.WmiClass;
import io.quarkus.runtime.annotations.RegisterForReflection;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@WmiClass(className = "Win32_UserAccount")
@RegisterForReflection
@Schema(
        name = "Win32_UserAccount",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-useraccount)"
)
public record Win32UserAccount(

        @JsonProperty("SID")
        @Schema(
                description = """
                        Security identifier (SID) for this account.
                        
                        A SID is a string value of variable length that is used to identify a trustee.
                        Each account has a unique SID that an authority, such as a Windows domain, issues.
                        The SID is stored in the security database.
                        When a user logs on, the system retrieves the user SID from the database,
                        places the SID in the user access token,
                        and then uses the SID in the user access token to identify the user
                        in all subsequent interactions with Windows security.
                        Each SID is a unique identifier for a user or group, and a different user or group cannot have the same SID.
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String sid,

        @JsonProperty("SIDType")
        @Schema(
                description = """
                        Type of SID.
                        
                        Possible values:
                        - 1 — User
                        - 2 — Group
                        - 3 — Domain
                        - 4 — Alias
                        - 5 — WellKnownGroup
                        - 6 — DeletedAccount
                        - 7 — Invalid
                        - 8 — Unknown
                        - 9 — Computer
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer sidType,

        @JsonProperty("AccountType")
        @Schema(
                description = """
                        Type of user account.
                        
                        Possible values:
                        - 256 — Temporary duplicate account
                        - 512 — Normal account
                        - 2048 — Interdomain trust account
                        - 4096 — Workstation trust account
                        - 8192 — Server trust account
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long accountType,

        @JsonProperty("Caption")
        @Schema(
                description = "Caption of the user account in the format domain/username.",
                nullable = true,
                type = SchemaType.STRING
        )
        String caption,

        @JsonProperty("Description")
        @Schema(
                description = "Description of the user account.",
                nullable = true,
                type = SchemaType.STRING
        )
        String description,

        @JsonProperty("Domain")
        @Schema(
                description = "Domain to which the user account belongs.",
                nullable = true,
                type = SchemaType.STRING
        )
        String domain,

        @JsonProperty("Name")
        @Schema(
                description = "Name of the user account.",
                nullable = true,
                type = SchemaType.STRING
        )
        String name,

        @JsonProperty("Disabled")
        @Schema(
                description = "Indicates whether the account is disabled.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean disabled,

        @JsonProperty("LocalAccount")
        @Schema(
                description = "Indicates whether this is a local account.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean localAccount,

        @JsonProperty("Lockout")
        @Schema(
                description = "Indicates whether the account is locked out.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean lockout,

        @JsonProperty("PasswordRequired")
        @Schema(
                description = "Indicates whether a password is required for the account.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean passwordRequired,

        @JsonProperty("PasswordExpires")
        @Schema(
                description = "Indicates whether the password expires.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean passwordExpires,

        @JsonProperty("PasswordChangeable")
        @Schema(
                description = "Indicates whether the password can be changed.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean passwordChangeable,

        @JsonProperty("Status")
        @Schema(
                description = """
                        Current operational status of the account.
                        
                        Possible OPERATIONAL values:
                        - "OK"
                        - "Degraded"
                        - "Pred Fail"
                        
                        Possible NON-OPERATIONAL values:
                        - "Unknown"
                        - "Error"
                        - "Starting"
                        - "Stopping"
                        - "Service"
                        
                        Possible OTHER values:
                        - "Stressed"
                        - "NonRecover"
                        - "No Contact"
                        - "Lost Comm"
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String status

) {
}