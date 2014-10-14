/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2014-07-09 17:08:39 UTC)
 * on 2014-07-23 at 23:58:13 UTC 
 * Modify at your own risk.
 */

package com.google.cloud.backend.android.mobilebackend.model;

/**
 * Model definition for QueryDto.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the mobilebackend. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class QueryDto extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private FilterDto filterDto;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String kindName;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer limit;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String queryId;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String regId;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String scope;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean sortAscending;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String sortedPropertyName;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer subscriptionDurationSec;

  /**
   * @return value or {@code null} for none
   */
  public FilterDto getFilterDto() {
    return filterDto;
  }

  /**
   * @param filterDto filterDto or {@code null} for none
   */
  public QueryDto setFilterDto(FilterDto filterDto) {
    this.filterDto = filterDto;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getKindName() {
    return kindName;
  }

  /**
   * @param kindName kindName or {@code null} for none
   */
  public QueryDto setKindName(java.lang.String kindName) {
    this.kindName = kindName;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getLimit() {
    return limit;
  }

  /**
   * @param limit limit or {@code null} for none
   */
  public QueryDto setLimit(java.lang.Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getQueryId() {
    return queryId;
  }

  /**
   * @param queryId queryId or {@code null} for none
   */
  public QueryDto setQueryId(java.lang.String queryId) {
    this.queryId = queryId;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getRegId() {
    return regId;
  }

  /**
   * @param regId regId or {@code null} for none
   */
  public QueryDto setRegId(java.lang.String regId) {
    this.regId = regId;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getScope() {
    return scope;
  }

  /**
   * @param scope scope or {@code null} for none
   */
  public QueryDto setScope(java.lang.String scope) {
    this.scope = scope;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getSortAscending() {
    return sortAscending;
  }

  /**
   * @param sortAscending sortAscending or {@code null} for none
   */
  public QueryDto setSortAscending(java.lang.Boolean sortAscending) {
    this.sortAscending = sortAscending;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getSortedPropertyName() {
    return sortedPropertyName;
  }

  /**
   * @param sortedPropertyName sortedPropertyName or {@code null} for none
   */
  public QueryDto setSortedPropertyName(java.lang.String sortedPropertyName) {
    this.sortedPropertyName = sortedPropertyName;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getSubscriptionDurationSec() {
    return subscriptionDurationSec;
  }

  /**
   * @param subscriptionDurationSec subscriptionDurationSec or {@code null} for none
   */
  public QueryDto setSubscriptionDurationSec(java.lang.Integer subscriptionDurationSec) {
    this.subscriptionDurationSec = subscriptionDurationSec;
    return this;
  }

  @Override
  public QueryDto set(String fieldName, Object value) {
    return (QueryDto) super.set(fieldName, value);
  }

  @Override
  public QueryDto clone() {
    return (QueryDto) super.clone();
  }

}
