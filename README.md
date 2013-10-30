# Data Service Base

Data Service Base is a common starting point for creating data services that I use to collect data.

## Usage

First clone the project into it own folder

    git clone https://github.com/bblanton/DSB.git {folder-name}

Modify the service/content/job.clj file with your own service definition.  The only requirement is that this file must implement a run funciton.

You can also modify the the logging location in the service/core/init.clj file.

Scheduling is set in the service/core/main.clj file.

In a future release scheduling and logging location withh be configured using the service.conf file.
