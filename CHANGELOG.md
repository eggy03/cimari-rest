# Changelog

All notable changes to this project will be documented in this file.

Please check out the [Releases](https://github.com/eggy03/cimari-rest/releases) page to know more about the
commits and PRs that contributed to each of the releases.

This project tries its best to adhere to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

The following headings may be used while categorizing the list of changes made in each version:

- New Features
- Removed Features
- Bug Fixes
- Non-Breaking Changes
- Breaking Changes
- Test Changes
- Dependency Updates
- Documentation
- Known Issues

## [0.0.2] - May 24, 2026

### Non-Breaking Changes

- Datetime inner record in MsftNetIpAddress record has been made public
- Remove redundant `Objects.requireNonNull` checks in `QueryUtility.java` since Lombok's `@Nonnull` adds runtime checks

### Test Changes

- Add unit tests for controllers, mappers, services and utility classes
- Add `run-tests.yml` workflow

### Dependency Updates

- Add assertj-core 3.27.7
- Add quarkus-junit-mockito

###

## [0.0.1] - May 22, 2026

- Initial Release
- Contains Endpoints for:
  - Win32_DesktopMonitor
  - Win32_VideoController
  - Win32_Baseboard
  - Win32_BIOS
  - Win32_PortConnector
  - Win32_PhysicalMemory
  - MSFT_DNSClientServerAddress
  - MSFT_NetAdapter
  - MSFT_NetConnectionProfile
  - MSFT_NetIPAddress
  - Win32_Battery
  - Win32_Printer
  - Win32_SoundDevice
  - Win32_CacheMemory
  - Win32_Processor
  - Win32_DiskDrive
  - Win32_DiskPartition
  - Win32_LogicalDisk
  - Win32_ComputerSystem
  - Win32_Environment
  - Win32_OperatingSystem
  - Win32_PnPEntity
  - Win32_Process
  - Win32_UserAccount