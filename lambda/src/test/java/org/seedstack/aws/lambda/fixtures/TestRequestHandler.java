/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.aws.lambda.fixtures;

import com.amazonaws.services.lambda.runtime.Context;
import org.seedstack.aws.lambda.BaseRequestHandler;

import javax.inject.Inject;
import javax.inject.Named;

public class TestRequestHandler extends BaseRequestHandler<String, String> {
    @Inject
    @Named("en")
    private Greeter greeter;

    @Override
    public String handleRequest(String input, Context context) {
        return greeter.greet(input);
    }
}
