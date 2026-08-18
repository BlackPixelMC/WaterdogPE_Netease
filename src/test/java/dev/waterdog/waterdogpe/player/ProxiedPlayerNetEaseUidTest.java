/*
 * Copyright 2026 WaterdogTEAM
 * Licensed under the GNU General Public License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.waterdog.waterdogpe.player;

import dev.waterdog.waterdogpe.network.protocol.user.LoginData;
import dev.waterdog.waterdogpe.transfer.TransferTestHarness;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ProxiedPlayerNetEaseUidTest {

    @Test
    void returnsNetEaseUidFromAuthenticatedLoginData() {
        try (TransferTestHarness harness = new TransferTestHarness()) {
            when(harness.loginData.getNetEaseData()).thenReturn(new LoginData.NetEaseData(
                    123456789L, "session", "platform", "os", "env", "engine", "patch", "64"));

            assertEquals(123456789L, harness.player.getNetEaseUid());
        }
    }

    @Test
    void returnsMinusOneWhenNetEaseDataIsUnavailable() {
        try (TransferTestHarness harness = new TransferTestHarness()) {
            assertEquals(-1L, harness.player.getNetEaseUid());
        }
    }
}
