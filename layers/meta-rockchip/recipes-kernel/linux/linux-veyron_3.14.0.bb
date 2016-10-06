# Copyright (C) 2015 Romain Perier
# Released under the MIT license (see COPYING.MIT for the terms)

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

# As this package is really well integrated into archlinuxarm and applies interesting fixes,
# I synced my work with it. See https://github.com/archlinuxarm/PKGBUILDs/tree/master/core/linux-veyron
SRC_URI = "git://chromium.googlesource.com/chromiumos/third_party/kernel;protocol=http;nobranch=1 \
        file://0001-use-chromiumos-mwifiex-drivers.patch \
	file://0002-mwifiex-do-not-create-AP-and-P2P-interfaces-upon-dri.patch \
	file://0003-UPSTREAM-soc-rockchip-add-handler-for-usb-uart-funct.patch \
	file://0004-fix-brcmfmac-oops-and-race-condition.patch \
	file://defconfig"
SRCREV = "6fa09265d61db1c29203c8194badebcfee86d97f"

# Override this variable in order to don't pass --noallconfig to configme,
# which restarts configuration from scratch most of the time
KCONFIG_MODE = " "
LINUX_VERSION = "3.14.0"
# Override local version in order to use the one generated by linux build system
# And not "yocto-standard"
LINUX_VERSION_EXTENSION = ""
PR = "r1"
PV = "${LINUX_VERSION}"

COMPATIBLE_MACHINE = "(rk3288-veyron-speedy)"
# The chromeos kernel uses the wifi subsystem v3.8
export WIFIVERSION="-3.8"

