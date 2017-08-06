/*
 * This file is part of GriefPrevention, licensed under the MIT License (MIT).
 *
 * Copyright (c) bloodmc
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package me.ryanhamshire.griefprevention.provider;

import me.ryanhamshire.griefprevention.DataStore;
import me.ryanhamshire.griefprevention.GriefPreventionPlugin;
import me.ryanhamshire.griefprevention.api.GriefPreventionApi;
import me.ryanhamshire.griefprevention.api.claim.Claim;
import me.ryanhamshire.griefprevention.api.claim.Claim.Builder;
import me.ryanhamshire.griefprevention.api.claim.ClaimManager;
import me.ryanhamshire.griefprevention.api.data.PlayerData;
import me.ryanhamshire.griefprevention.api.economy.BankTransaction;
import me.ryanhamshire.griefprevention.claim.GPClaim;
import me.ryanhamshire.griefprevention.economy.GPBankTransaction;
import org.spongepowered.api.world.storage.WorldProperties;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class GPApiProvider implements GriefPreventionApi {

    public static final double API_VERSION = 0.5;

    public GPApiProvider() {
    }

    @Override
    public double getApiVersion() {
        return API_VERSION;
    }

    @Override
    public ClaimManager getClaimManager(WorldProperties worldProperties) {
        return GriefPreventionPlugin.instance.dataStore.getClaimWorldManager(worldProperties);
    }

    @Override
    public Builder createClaimBuilder() {
        return new GPClaim.ClaimBuilder();
    }

    @Override
    public BankTransaction.Builder createBankTransactionBuilder() {
        return new GPBankTransaction.BankTransactionBuilder();
    }

    @Override
    public Optional<PlayerData> getGlobalPlayerData(UUID playerUniqueId) {
        return Optional.ofNullable(DataStore.GLOBAL_PLAYER_DATA.get(playerUniqueId));
    }

    @Override
    public Optional<PlayerData> getWorldPlayerData(WorldProperties worldProperties, UUID playerUniqueId) {
        return Optional.ofNullable(GriefPreventionPlugin.instance.dataStore.getPlayerData(worldProperties, playerUniqueId));
    }

    @Override
    public List<Claim> getAllPlayerClaims(UUID playerUniqueId) {
        // TODO Auto-generated method stub
        return null;
    }
}
