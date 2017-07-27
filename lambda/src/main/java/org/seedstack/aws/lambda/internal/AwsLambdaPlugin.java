/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.aws.lambda.internal;

import org.seedstack.seed.core.internal.AbstractSeedPlugin;

/**
 * This plugins makes AWS lambda handlers injectable.
 */
public class AwsLambdaPlugin extends AbstractSeedPlugin {
    @Override
    public String name() {
        return "aws-lambda";
    }

    @Override
    public Object nativeUnitModule() {
        return new AwsLambdaModule();
    }
}
