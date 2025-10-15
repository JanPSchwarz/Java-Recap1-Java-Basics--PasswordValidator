# Password Validator

This is a recap project building a small tool to validate a given password. It's part of the Java Bootcamp Basic
Lectures.

## Password requirements policy

- min. Length: ***8***
- min. integer(s): ***1***
- min. capital char(s): ***1***
- min. non-capital char(s): ***1***
- min. special char(s): ***1***
- special char(s) must be one of: ***!@#$%^&\*()-_+=?.,;:***
- ***must not be*** part of a list of ***weak*** passwords

## Build/Run/Tests

- locally: `mvn clear verify`
- Artefact: `mvn package` -> `target/*.jar`

### Build Status:

[![Java CI with Maven](https://github.com/JanPSchwarz/Java-Recap1-Java-Basics--PasswordValidator/actions/workflows/maven.yml/badge.svg)](https://github.com/JanPSchwarz/Java-Recap1-Java-Basics--PasswordValidator/actions/workflows/maven.yml)

## Use CLI like this

`Would you like to generate a Password(1) or try our own password(2)? Enter a number:`

`2`

`Enter a password:`

`test`

`Password is invalid!`

`Password report:`

| Requirment                    | Passed |
|-------------------------------|--------|
| Minimum length (8 characters) | ✗ No   |
| No whitespace                 | ✓ Yes  |
| At least 1 digit              | ✗ No   |
| Upper and lowercase letters   | ✗ No   |
| At least 1 special character  | ✗ No   |
| Not a common password         | ✓ Yes  |

`Would you like to generate a Password(1) or try our own password(2)? Enter a number:`

`1`

`Enter a Password length (8-20):`

`10`

`Looped for 2 iterations!`

`New Password: $h^to6oX*n`

`Password valid!`