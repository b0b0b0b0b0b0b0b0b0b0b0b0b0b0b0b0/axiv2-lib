package com.moulberry.axiοm.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Authorization {
    private static boolean hasCommercialLicense = true;
    public static boolean hasServerCommercialLicense = true;

    public Authorization() {}

    public static String getUserAgent() {
        return "Axiom/4.6.2";
    }

    public static CompletableFuture<Meta> getMeta() {
        return CompletableFuture.supplyAsync(() -> {
            List<String> changelog = new ArrayList<>();
            changelog.add("Мод был Взломан: bobobo & Kwilz");
            changelog.add("https://black-minecraft.com/resources/4766/");

            return new Meta("4.6.2", changelog, null, false);
        });
    }

    public static CompletableFuture<Boolean> checkCommercial() {
        return CompletableFuture.completedFuture(true);
    }

    public static CompletableFuture<ServerAuthorization> checkServer(String server, String host) {
        return CompletableFuture.completedFuture(ServerAuthorization.COMMERCIAL);
    }

    public static boolean hasCommercialLicense() {
        return hasCommercialLicense || hasServerCommercialLicense;
    }

    public static final class ServerAuthorization {
        public static final ServerAuthorization YES = new ServerAuthorization();
        public static final ServerAuthorization NO = new ServerAuthorization();
        public static final ServerAuthorization COMMERCIAL = new ServerAuthorization();
    }

    public static final class Meta {
        private final String latestModVersion;
        private final List<String> latestChangelog;
        private final String modDisabled;
        private final boolean test;

        public Meta(String latestModVersion, List<String> latestChangelog, String modDisabled, boolean test) {
            this.latestModVersion = latestModVersion;
            this.latestChangelog = latestChangelog;
            this.modDisabled = modDisabled;
            this.test = test;
        }

        public String latestModVersion() {
            return latestModVersion;
        }

        public List<String> latestChangelog() {
            return latestChangelog;
        }

        public String modDisabled() {
            return modDisabled;
        }

        public boolean test() {
            return test;
        }
    }
}