/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.aws.lambda.internal;

import com.google.inject.AbstractModule;
import org.seedstack.aws.lambda.BaseRequestHandler;

class AwsLambdaModule extends AbstractModule {
    @Override
    protected void configure() {
        requestStaticInjection(BaseRequestHandler.class);
    }
}
