/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.aws.lambda.internal;

import io.nuun.kernel.api.Kernel;
import org.seedstack.seed.core.Seed;
import org.seedstack.seed.spi.SeedLauncher;

public class AwsLambdaLauncher implements SeedLauncher {
    private Kernel kernel;

    @Override
    public void launch(String[] args) throws Exception {
        kernel = Seed.createKernel();
    }

    @Override
    public void shutdown() throws Exception {
        if (kernel.isStarted()) {
            kernel.stop();
        }
    }
}
